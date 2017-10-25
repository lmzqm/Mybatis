package com.lmzqm.mybatis.Server;

import com.sun.corba.se.impl.encoding.BufferManagerRead;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lmzqm on 2017/10/20.
 */
@Service
public class FileActionServer {

    /**
     * 该文件主要是针对File的相关操作
     *
     * IO
     *
     *
     */

    private static final File file = new File("/Users/lmzqm/Downloads");

    /**
     * 获取文件的名字
     * @return 返回文件名
     */
    public String getFileName(){


       if(file.exists() && file.isDirectory()){

           System.out.println("file is a die");

           File[] files = file.listFiles();

           for (File f : files){
               f.getName();//获取文件的名称
               f.getPath();//获取文件的路径
               f.getAbsolutePath();//获取文件的绝对路径
               f.getParent();//获取文件父目录的路径
               f.exists();//判断文件是否存在
               f.canWrite();//判断文件是否可写
               f.canRead();//判断文件是否可读
               f.canExecute();//判断文件是否可以执行
               f.isDirectory();//判断是不是文件夹
               f.isFile();//判断是不是标准文件
               f.isAbsolute();//判断路径是不是绝对路径
               f.lastModified();//获取文件最后一次修改的时间
               f.length();//获取文件的字节数
               f.toURI();//获取文件路径URI后的路径


           }
       }

       return file.getName();

    }

    /**
     *
     * @param str
     * @return
     * @throws IOException
     */

    public String getRandomAccessFile( String str) throws IOException {

//        RandomAccessFile file = new RandomAccessFile("","r");
        File file = new File("");
        FileOutputStream fostream = null;
        try  {

            fostream = new FileOutputStream(file, true);
//            String str = "Hello World";
            fostream.write(str.getBytes());

            byte[] bytes = new byte[1024];

            fostream.write(bytes,0,1024);

            System.out.println(bytes.toString());


            FileInputStream inputStream = new FileInputStream(file);
            inputStream.read(bytes);

            Reader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

        }catch (FileNotFoundException e) {

        }finally {
            fostream.close();
        }


        return "successful";
    }

    public void getArrayListAction(){

        List<String> list = new ArrayList<String>();
        list.add("111");//添加操作
        list.add("222");

        list.isEmpty();
        list.size();

        list.contains("111");//判断是否包含
        list.remove("111");//返回true，如果包含这个值得话
        Integer index =  list.indexOf("111");//获取某个值得位置
        if(index != -1){
            list.remove(index); //shift+alt + down and up表示移动上下行的操作

        }


    }

    public void getHashMapAction(){

        Map<String,String> map = new HashMap<>();
    }





}
