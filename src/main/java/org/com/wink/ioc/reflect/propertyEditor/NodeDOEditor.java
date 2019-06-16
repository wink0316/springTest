package org.com.wink.ioc.reflect.propertyEditor;


import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class NodeDOEditor extends PropertyEditorSupport {

    public final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        String[] split = text.split("\\|");
        NodeDO nodeDO = new NodeDO();
        nodeDO.setName(split[0]);
        nodeDO.setEmail(split[1]);
        try {
            nodeDO.setDateTime(format.parse(split[2]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        setValue(nodeDO);
    }
}
