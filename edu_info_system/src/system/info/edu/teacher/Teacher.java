package system.info.edu.teacher;

public class Teacher {
    private String id;
    private String name;
    private String age;
    private String birthday;
    private String subject;
    public Teacher(){
    }
    public Teacher(String id,String name,String age,String birthday,String subject){
        this.id=id;
        this.name=name;
        this.age=age;
        this.birthday=birthday;
        this.subject=subject;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAge(String age){
        this.age=age;
    }
    public void setBirthday(String birthday){
        this.birthday=birthday;
    }
    public void setSubject(String subject){
        this.subject=subject;
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
    public String getSubject(){
        return this.subject;
    }
}
