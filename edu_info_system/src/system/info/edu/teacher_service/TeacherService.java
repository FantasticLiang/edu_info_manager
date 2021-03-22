package system.info.edu.teacher_service;
import system.info.edu.teacher_dao.TeacherDao;
import system.info.edu.teacher.Teacher;
public class TeacherService {
    TeacherDao teacherDao=new TeacherDao();
    Teacher[] teachers=teacherDao.getTeachers();
    public boolean isExist(String id){
        boolean result=false;
        for(int i=0;i<teachers.length;i++){
            Teacher teacher=teachers[i];
            if(teacher!=null&&teacher.getId().equals(id)){
                result=true;
            }
        }
        return result;
    }
    public boolean addStudent(String id,String name,String age,String birthday,String subject){
        boolean result=false;
        for(int i=0;i<teachers.length;i++){
            if(teachers[i]==null){
                teachers[i]=new Teacher(id,name,age,birthday,subject);
                result=true;
                break;
            }
        }
        return result;
    }
    public void showTeacher(){
        System.out.println("id    name    age    birthday    subject");
        for(int i=0;i<teachers.length;i++){
            Teacher teacher=teachers[i];
            if(teacher!=null){
                System.out.println(teacher.getId()+" "+teacher.getName()+" "+teacher.getAge()+" "+teacher.getBirthday()+" "+teacher.getSubject());
            }
        }
    }
    public boolean deleteTeacher(String id){
        boolean result=false;
        for(int i=0;i<teachers.length;i++){
            Teacher teacher=teachers[i];
            if(teacher!=null&&teacher.getId().equals(id)){
                teachers[i]=null;
                result=true;
                break;
            }
        }
        return result;
    }
    public boolean changeTeacher(String id,String name,String age,String birthday,String subject){
        boolean result=false;
        for(int i=0;i<teachers.length;i++){
            Teacher teacher=teachers[i];
            if(teacher!=null&&teacher.getId().equals(id)){
                Teacher newTeacher=new Teacher(id,name,age,birthday,subject);
                teachers[i]=newTeacher;
                result=true;
                break;
            }
        }
        return result;
    }
}
