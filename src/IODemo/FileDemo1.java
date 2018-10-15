package IODemo;

import java.io.File;

public  class FileDemo1 {
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
