package system.info.edu.service;
import system.info.edu.dao.TeacherDao;
import system.info.edu.domain.Teacher;
public class TeacherService {
    private TeacherDao teacherDao=new TeacherDao();
    public boolean isExist(String id){
        Teacher[] teachers=teacherDao.findAllTeacher();
        boolean result=false;
        for(int i=0;i<teachers.length;i++){
            Teacher teacher=teachers[i];
            if(teacher!=null&&teacher.getId().equals(id)){
                result=true;
                break;
            }
        }
        return result;
    }
    public boolean addTeacher(Teacher teacher){
        return teacherDao.addTeacher(teacher);
    }
    public Teacher[] findAllTeacher(){
        Teacher[] teachers=teacherDao.findAllTeacher();
        boolean result=false;
        for(int i=0;i<teachers.length;i++){
            Teacher teacher=teachers[i];
            if(teacher!=null){
                result=true;
                break;
            }
        }
        if(result){
            return teachers;
        }else{
            return null;
        }
    }
    public void deleteTeacher(String id){
        teacherDao.deleteTeacher(id);
    }
    public void updateTeacher(String id,Teacher teacher){
        teacherDao.updateTeacher(id,teacher);
    }
}
