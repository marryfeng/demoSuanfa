package IODemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/15
 * @Version: 1.0
 */
//字符输出流：即String,StringBuffer,StringBuilder.而字节输出流对应这byte类型的数据操作
    //字符处理的优势在与于中文数据的处理
public class WriterDemo {
    public static void main(String[] args) throws IOException {
        File file=new File("D:"+File.separator+"fileDemo" +
                File.separator+"hello"+File.separator+"hello.txt");//1、指定文件目录
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
       Writer writer=new FileWriter(file);
        String str="hhhhhh\r\n";
        writer.write(str);
        writer.append("中国人民万岁");
        writer.close();

    }

}
