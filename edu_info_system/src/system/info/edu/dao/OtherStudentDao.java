package system.info.edu.dao;
import java.util.ArrayList;

import com.sun.deploy.net.MessageHeader;
import system.info.edu.domain.Student;

import javax.swing.plaf.basic.BasicEditorPaneUI;

public class OtherStudentDao implements BaseStudentDao {
    private static ArrayList<Student> stus=new ArrayList<Student>();
    static{
        Student stu1=new Student("1","1","1","1");
        stus.add(stu1);
    }
    public boolean addStudent(Student stu){
        stus.add(stu);
        return true;
    }
    @Override
    public Student[] findAllStudent(){
        Student[] students=new Student[stus.size()];
        for(int i=0;i<students.length;i++){
            students[i]=stus.get(i);
        }
        return students;
    }
    public void deleteStudent(String id){
        int index=getIndex(id);
        stus.remove(index);
    }
    public int getIndex(String id){
        int index=-1;
        for(int i=0;i<stus.size();i++){
            Student stu=stus.get(i);
            if(stu!=null&&stu.getId().equals(id)){
                index=i;
                break;
            }
        }
        return index;
    }
    public void updateStudent(String id,Student stu){
        int index=getIndex(id);
        stus.set(index,stu);
    }
}
