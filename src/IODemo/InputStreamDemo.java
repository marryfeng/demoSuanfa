package IODemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/15
 * @Version: 1.0
 */
//inputStream的使用
public class InputStreamDemo {
    public static void main(String[] args) throws Exception {
        File file=new File("D:"+File.separator+"fileDemo" +
                File.separator+"hello"+File.separator+"hello.txt");//1、指定文件目录
        InputStream input=new FileInputStream(file);
        byte[] data=new byte[1024];
        //读取了数据并写入到data中
        int len = input.read(data);
        System.out.println(new String(data,0,len));

    }
}
