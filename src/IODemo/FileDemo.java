package IODemo;

import java.io.File;
import java.io.IOException;

//File类对文件的操作不是对文件内容的操作：创建（构造方法）、删除，判断是否存在，创建文件。最常见的几种操作
    public  class FileDemo {
        public static void main(String[] args) throws IOException {
            //file构造方法中创建文件添加的路径：即表示即将在d盘创建一个文件名为fileText.txt的文件
            //文件路径的写法:具体写法看个人习惯
            //File file=new File("d:"+File.separator+"fileText.txt");
            //File file=new File("d:/fileText.txt");
            //File file=new File("d:\\fileText.txt");
           // File file=new File("d:"+File.separator+"fileDemo"+File.separator+"fileText.txt");
            File file=new File("d:\\fileDemo\\file.txt");
            //此时父目录不存在，这个时候，我们需要判断父目录的存在性。
            if (!file.getParentFile().exists()){
                //mkdir为创建单级目录，mkdirs创建多级目录
                file.getParentFile().mkdirs();
            }
            //为了提升性能，我们通常保证父目录存在，降低时间复杂度
            //判断d盘中这个文件是否存在，如果存在则删除，不存在则创建
            if (file.exists()){
                file.delete();
            }else{
                //file.createNewFile()文件创建
                System.out.println(file.createNewFile());
            }
        }


    }
