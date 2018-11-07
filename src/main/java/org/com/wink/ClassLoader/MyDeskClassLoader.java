package org.com.wink.ClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 参考博客
 * https://blog.csdn.net/u013851082/article/details/71723777
 */
public class MyDeskClassLoader extends ClassLoader{

    private String deskClassPath;

    public MyDeskClassLoader(String deskClassPath){
        this.deskClassPath = deskClassPath;
    }

    public String getFileName(String name){
        int index = name.lastIndexOf(".");
        if(index == -1){
            return name+".class";
        }else{
            return name.substring(index + 1)+".class";
        }
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String fileName = getFileName(name);
        File file = new File(deskClassPath,fileName);

        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len = 0;
            while ((len = fis.read()) != -1){
                bos.write(len);
            }
            byte[] data = bos.toByteArray();
            fis.close();
            bos.close();

            return defineClass(name,data,0,data.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
