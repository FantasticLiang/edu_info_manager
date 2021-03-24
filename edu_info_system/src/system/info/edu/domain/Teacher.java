package system.info.edu.domain;

public class Teacher extends Person{
    private String subject;
    public Teacher(){
        super();
    }
    public Teacher(String id,String name,String age,String birthday,String subject){
        super(id,name,age,birthday);
        this.subject=subject;
    }
    public void setSubject(String subject){
        this.subject=subject;
    }
    public String getSubject(){
        return this.subject;
    }
}
