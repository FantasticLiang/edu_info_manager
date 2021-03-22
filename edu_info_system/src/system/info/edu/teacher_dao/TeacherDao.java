package system.info.edu.teacher_dao;
import system.info.edu.teacher.Teacher;
public class TeacherDao {
    public static Teacher[] teachers=new Teacher[5];
    public Teacher[] getTeachers(){
        return teachers;
    }
}
