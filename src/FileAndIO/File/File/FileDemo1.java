package FileAndIO.File.File;

import java.io.File;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/15
 * @Version: 1.0
 */
//列出某个目录中的所有文件：包括子目录里面的文件：递归
public class FileDemo1 {
    public static void main(String[] args) {
        //列出d盘中的所有文件
        File file=new File("d:"+File.separator);
        listDir(file);
    }
    public static void listDir(File file){
        if (file.isDirectory()) {//判断是否是目录
            //如果file是个目录，则列出该目录列表
            File results[] = file.listFiles();//该文件下目录的列出：列出的路径，因为构造方法中就是文件的路径
            if (results != null) {
                for (int i = 0; i < results.length; i++) {
                    listDir(results[i]);
                }
            }
        }
        System.out.println(file);
    }
}

