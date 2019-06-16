package org.com.wink.ioc.reflect.propertyEditor;

import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class PropertiesEditorSample {

    private final static Field[] fields = TestDO.class.getDeclaredFields();

    static {
        PropertyEditorManager.registerEditor(NodeDO.class,NodeDOEditor.class);
    }

    public static void main(String[] args) {
        Map<String,String> params = new HashMap(){
          private final Long serialVersionUID = 1l;
            {
                put("nodeName","wink");
                put("nodeDO","wink|wink@163.com|2019-11-11 11:11:11");
            }
        };

        try {
            TestDO testDO = converStringToTestDO(params);
            System.out.println(testDO.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static TestDO converStringToTestDO(Map<String,String> params) throws Exception{
        TestDO testDO = new TestDO();
        for (Field field : fields) {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), TestDO.class);
            Method method = propertyDescriptor.getWriteMethod();
            if(field.getType() == String.class){
                method.invoke(testDO,params.get(field.getName()));
            }else if(field.getType() == NodeDO.class){
                PropertyEditor editor = PropertyEditorManager.findEditor(NodeDO.class);
                if(editor != null){
                    editor.setAsText(params.get(field.getName()));
                    method.invoke(testDO,editor.getValue());
                }else{
                    System.out.println("can not find editor!!!!!");
                }
            }else {
                System.out.println("unknown type!!!!!");
            }
        }
        return testDO;
    }
}
