package system.info.edu.dao;
import system.info.edu.domain.Student;
public class StudentDao {
    private static Student[] stus=new Student[5];
    public boolean addStudent(Student stu){
        int index=-1;
        for(int i=0;i<stus.length;i++){
            Student student=stus[i];
            if(student==null){
                index=i;
                break;
            }
        }
        if(index==-1){
            return false;
        }else{
            stus[index]=stu;
            return true;
        }
    }
    public Student[] findAllStudent(){
        return stus;
    }
    public void deleteStudent(String id){
        int index=getIndex(id);
        stus[index]=null;
    }
    public int getIndex(String id){
        int index=-1;
        for(int i=0;i<stus.length;i++){
            Student stu=stus[i];
            if(stu!=null&&stu.getId().equals(id)){
                index=i;
                break;
            }
        }
        return index;
    }
    public void updateStudent(String id,Student stu){
        int index=getIndex(id);
        stus[index]=stu;
    }
}
