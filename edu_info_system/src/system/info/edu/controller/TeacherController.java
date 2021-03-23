package system.info.edu.controller;
import java.util.Scanner;
import system.info.edu.service.TeacherService;
import system.info.edu.domain.Teacher;
public class TeacherController {
    Scanner sc=new Scanner(System.in);
    private TeacherService teacherService=new TeacherService();
    public void start(){
        loop:while(true){
            System.out.println("Welcome to Teacher System");
            System.out.println("1.Add Teacher");
            System.out.println("2.Delete Teacher");
            System.out.println("3.Update Teacher");
            System.out.println("4.Show All Teachers");
            System.out.println("5.Exit");
            System.out.println("Please enter the number to use the function:");
            String choose=sc.next();
            switch(choose){
                case "1":
                    addTeacher();
                    break;
                case "2":
                    deleteTeacher();
                    break;
                case "3":
                    updateTeacher();
                    break;
                case "4":
                    findAllTeacher();
                    break;
                case "5":
                    break loop;
                default:
                    System.out.println("Please enter the correct number");
            }
        }

    }
    public void addTeacher(){
        String id;
        while(true){
            System.out.println("Please enter the id:");
            id=sc.next();
            boolean exists=teacherService.isExist(id);
            if(!exists){
                break;
            }else{
                System.out.println("Repeat student, Please enter the different id");
            }
        }
        Teacher teacher=inputInfo(id);
        boolean result=teacherService.addTeacher(teacher);
        if(result){
            System.out.println("Add success");
        }else{
            System.out.println("Add failed");
        }
    }
    public Teacher inputInfo(String id){
        System.out.println("Please enter the name:");
        String name=sc.next();
        System.out.println("Please enter the age:");
        String age=sc.next();
        System.out.println("Please enter the birthday:");
        String birthday=sc.next();
        System.out.println("Please enter the subject:");
        String subject=sc.next();
        Teacher newTeacher=new Teacher(id,name,age,birthday,subject);
        return newTeacher;
    }
    public void findAllTeacher(){
        Teacher[] teachers=teacherService.findAllTeacher();
        if(teachers==null){
            System.out.println("No teacher information");
        }else{
            System.out.println("Id Name Age Birthday Subject");
            for(int i=0;i<teachers.length;i++) {
                Teacher teacher = teachers[i];
                if (teacher != null) {
                    System.out.println(teacher.getId() + " " + teacher.getName() + " " + teacher.getAge() + " " + teacher.getBirthday() + " " + teacher.getSubject());
                }
            }
        }
    }
    public void deleteTeacher(){
        String id=inputId();
        teacherService.deleteTeacher(id);
        System.out.println("Delete Success");
    }
    public String inputId(){
        String id;
        while(true){
            System.out.println("Please enter the id:");
            id=sc.next();
            boolean exists=teacherService.isExist(id);
            if(!exists){
                System.out.println("No this teacher");
            }else{
                break;
            }
        }
        return id;
    }
    public void updateTeacher(){
        String id=inputId();
        Teacher teacher=inputInfo(id);
        teacherService.updateTeacher(id,teacher);
        System.out.println("Update Success");
    }
}
