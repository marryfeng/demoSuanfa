package IODemo;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/15
 * @Version: 1.0
 */
//字符流操作：读取文件中内容
public class ReaderDemo {
    public static void main(String[] args) throws Exception {
        File file=new File("D:"+File.separator+"fileDemo" +
                File.separator+"hello"+File.separator+"hello.txt");//1、指定文件目录
        //不能全部读取，只能利用字符数组来接收读取的内容
        Reader reader=new FileReader(file);
        char data[]=new char[1024];
        int len = reader.read(data);
        System.out.println(new java.lang.String(data,0,len));
        reader.close();
    }
}
