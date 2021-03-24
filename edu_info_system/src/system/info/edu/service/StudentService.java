package system.info.edu.service;
import system.info.edu.domain.Student;
import system.info.edu.dao.OtherStudentDao;
public class StudentService {
    private OtherStudentDao studentDao=new OtherStudentDao();
    public boolean addStudent(Student stu){
        return studentDao.addStudent(stu);
    }
    public boolean isExist(String id){
        Student[] stus=studentDao.findAllStudent();
        boolean exists=false;
        for(int i=0;i<stus.length;i++){
            Student stu=stus[i];
            if(stu!=null&&stu.getId().equals(id)){
                exists=true;
                break;
            }
        }
        return exists;
    }
    public Student[] findAllStudent(){
        Student[] stus=studentDao.findAllStudent();
        boolean flag=false;
        for(int i=0;i<stus.length;i++){
            if(stus[i]!=null){
                flag=true;
                break;
            }
        }
        if(flag){
            return stus;
        }else{
            return null;
        }
    }
    public void deleteStudent(String id){
        studentDao.deleteStudent(id);
    }
    public void updateStudent(String id,Student stu){
        studentDao.updateStudent(id,stu);
    }
}
