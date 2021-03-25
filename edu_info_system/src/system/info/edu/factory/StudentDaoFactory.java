package system.info.edu.factory;
import system.info.edu.dao.BaseStudentDao;
import system.info.edu.dao.StudentDao;
import system.info.edu.dao.OtherStudentDao;
public class StudentDaoFactory {
    public static BaseStudentDao getStudentDao(){
        return new OtherStudentDao();
    }
}
