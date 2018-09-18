package arraydemo;

/**
 * @Author: li.feng
 * @Email: li.feng@rograndec.com
 * @CreateDate: 2018/9/18
 * @Version: 3.0
 */

public class Student {
    private String name;
    private Integer score;

    public Student(String stuName,Integer stuScore){
        this.name=stuName;
        this.score=stuScore;
    }
    @Override
    public String toString(){
        return String.format("student{name: %s,score: %d}",name,score);

    }

    public static void  main(String[] args){
        Array<Student> arr=new Array<>(20);
        arr.addLastElemplt(new Student("小明",10));
        arr.addLastElemplt(new Student("小强",100));
        System.out.println(arr);
    }
}
