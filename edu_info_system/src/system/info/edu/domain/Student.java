package system.info.edu.domain;

public class Student {
    private String id;
    private String name;
    private String age;
    private String birthday;
    public Student(){
    }
    public Student(String id,String name,String age,String birthday){
        this.id=id;
        this.name=name;
        this.age=age;
        this.birthday=birthday;
    }
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getAge(){
        return this.age;
    }
    public String getBirthday(){
        return this.birthday;
    }
}