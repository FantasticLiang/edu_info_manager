package system.info.edu.dao;
import system.info.edu.domain.Student;
public interface BaseStudentDao {
    public abstract Student[] findAllStudent();
    public boolean addStudent(Student stu);
    public abstract void deleteStudent(String id);
    public abstract int getIndex(String id);
    public abstract void updateStudent(String id,Student stu);
}
