package com.smart.chapter4.resource;

import org.springframework.core.io.*;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * 通过Spring的Resource实现类提供了访问同一个文件资源
 * @author niu on 9/19/18.
 */
public class FileSourceExample {
    public static void main(String[] args) {
        try {
            String filePath="/home/niu/Documents/IdeaProjects/java-spring4.x/chapter4/src/main/resources/conf/file1.txt";
            //使用系统文件路径方式加载文件
            WritableResource res1=new PathResource(filePath);
            //使用类路径方式加载文件
            Resource res2=new ClassPathResource("conf/file1.txt");
            //使用WritableResource接口写资源文件
            OutputStream stream=res1.getOutputStream();
            stream.write("欢迎光临\n小春论坛".getBytes());
            stream.close();
            //使用Resource接口读资源文件
            InputStream ins1=res1.getInputStream();
            InputStream ins2=res2.getInputStream();

            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            int i;
            while ((i=ins1.read())!=-1){
                baos.write(i);
            }
            System.out.println(baos.toString());

            System.out.println("res1:"+res1.getFilename());
            System.out.println("res2:"+res2.getFilename());

            EncodedResource encRes=new EncodedResource(res2, Charset.forName("UTF-8"));
            String context= FileCopyUtils.copyToString(encRes.getReader());
            System.out.println(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
