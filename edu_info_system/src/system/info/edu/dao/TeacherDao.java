package system.info.edu.dao;
import system.info.edu.domain.Teacher;
public class TeacherDao {
    private static Teacher[] teachers=new Teacher[5];
    public Teacher[] findAllTeacher(){
        return teachers;
    }
    public boolean addTeacher(Teacher teacher){
        int index=-1;
        for(int i=0;i<teachers.length;i++){
            Teacher newTeacher=teachers[i];
            if(newTeacher==null){
                index=i;
                break;
            }
        }
        if(index!=-1){
            teachers[index]=teacher;
            return true;
        }else{
            return false;
        }
    }
    public void deleteTeacher(String id){
        int index=getIndex(id);
        teachers[index]=null;
    }
    public int getIndex(String id){
        int index=-1;
        for(int i=0;i<teachers.length;i++){
            Teacher teacher=teachers[i];
            if(teacher!=null&&teacher.getId().equals(id)){
                index=i;
            }
        }
        return index;
    }
    public void updateTeacher(String id,Teacher teacher){
        int index=getIndex(id);
        teachers[index]=teacher;
    }
}
