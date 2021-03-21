package system.info.edu.student_service;
import system.info.edu.student_dao.StudentDao;
import system.info.edu.student.Student;
public class StudentService {
    private StudentDao studentdao=new StudentDao();
    private Student stu=new Student();
    public boolean isExist(String id){
        Student[] stus=studentdao.getStudents();
        boolean result=false;
        for(int i=0;i<stus.length;i++){
            if(stus[i]!=null&&stus[i].getId().equals(id)){
                result=true;
            }
        }
        return result;
    }
    public boolean addStudent(String id,String name,String age,String birthday){
        boolean result=false;
        int index=-1;
        for(int i=0;i<StudentDao.stus.length;i++){
            if(StudentDao.stus[i]==null){
                index=i;
                break;
            }
        }
        if(index!=-1){
            Student stu=new Student(id,name,age,birthday);
            StudentDao.stus[index]=stu;
            return true;
        }else{
            return false;
        }
    }
    public boolean deleteStudent(String id){
        boolean result=false;
        for(int i=0;i<StudentDao.stus.length;i++){
            Student stu=StudentDao.stus[i];
            if(stu!=null&&stu.getId().equals(id)){
                StudentDao.stus[i]=null;
                result=true;
                break;
            }
        }
        return result;
    }
    public boolean changeStudent(String id,String name,String age,String birthday){
        boolean result=false;
        Student stu=new Student(id,name,age,birthday);
        for(int i=0;i<StudentDao.stus.length;i++){
            if(StudentDao.stus[i]!=null&&StudentDao.stus[i].getId().equals(id)){
                StudentDao.stus[i]=stu;
                result=true;
                break;
            }
        }
        return result;
    }
    public void showStudent(){
        System.out.println("ID    Name    Age    Birthday");
        Student[] stus=StudentDao.stus;
        for(int i=0;i<stus.length;i++){
            if(stus[i]!=null) {
                System.out.println(stus[i].getId()+"  "+stus[i].getName()+"   "+stus[i].getAge()+"   "+stus[i].getBirthday());
            }
        }
    }
}
