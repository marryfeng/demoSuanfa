package IODemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/15
 * @Version: 1.0
 */

public class FileOutPutDemo {
    //输出操作：这里的输入输出都是相对而言的，比如我们向文件中写入内容，对于应用程序来讲是程序的输出者，文件是接收者
        public static void main(String[] args) throws Exception {
            File file=new File("D:"+File.separator+"fileDemo" +
                    File.separator+"hello"+File.separator+"hello.txt");//1、指定文件目录
            if (!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }

            /*OutputStream outPutStream=new FileOutputStream(file);//通过子类实例化
            //换行
            String str="www.baidu.com\r\n";
            outPutStream.write(str.getBytes());//2、写入资源
            outPutStream.close();//3、关闭资源*/
            //利用自动关闭
            try {
                OutputStream outPutStream=new FileOutputStream(file,true);//通过子类实例化,true表示文档可以追加文件中的内容
                //换行
                String str="www.baidu.com\r\n";
                outPutStream.write(str.getBytes());//2、写入资源，转换为数组的格式
            }catch (IOException e){
                e.printStackTrace();
            }

                  }
}
