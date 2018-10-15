package FileAndIO.File.File;

import java.io.File;

/**
 * @Author: marryFeng
 * @Email: 1473357859@qq.com
 * @CreateDate: 2018/10/15
 * @Version: 1.0
 */
//批量修改文件名称：将目录下的所有文件后缀修改为.txt的格式
public class FileDemo2 {
    public static void main(String[] args) {
        File file=new File("D:\\fileDemo");
        rnameFile(file);
    }

    private static void rnameFile(File file) {
        String fileName=null;
        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (files!=null){
            for (int i=0;i<files.length;i++){
                rnameFile(files[i]);
            }
        }}else{
            if (file.isFile()){
                if (file.getName().contains(".")){
                    fileName=file.getName().substring(0,file.getName().lastIndexOf("."))+".txt";
                }else{
                    fileName=file.getName()+".txt";

                }
            }
        }
        File newFile=new File(file.getParentFile(),fileName);
        file.renameTo(newFile);
    }
}
