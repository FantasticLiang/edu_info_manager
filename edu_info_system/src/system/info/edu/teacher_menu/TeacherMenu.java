package system.info.edu.teacher_menu;
import java.util.Scanner;
import system.info.edu.teacher_service.TeacherService;
public class TeacherMenu {
    Scanner sc=new Scanner(System.in);
    TeacherService teacherService=new TeacherService();
    public void start(){
        loop:while(true){
        System.out.println("WELCOME TO TEACHER SYSTEM");
        System.out.println("1.Add Teacher Information");
        System.out.println("2.Delete Teacher Information");
        System.out.println("3.Change Teacher Information");
        System.out.println("4.Show All Teachers");
        System.out.println("5.Exit");
        System.out.println("Please enter the number to use the function:");
        String choose=sc.next();
        switch(choose) {
            case "1":
                addTeacher();
                break;
            case "2":
                deleteTeacher();
                break;
            case "3":
                changeTeacher();
                break;
            case "4":
                showTeacher();
                break;
            case "5":
                break loop;
            default:
                System.out.println("Please enter the correct number!");
        }
        }
    }
    public void addTeacher(){
        String id;
        while(true){
            System.out.println("Please enter the id:");
            id=sc.next();
            boolean flag=teacherService.isExist(id);
            if(flag==true){
                System.out.println("Repeat id,please enter the correct id");
            }else{
                break;
            }
        }
        System.out.println("Please enter the name:");
        String name=sc.next();
        System.out.println("Please enter the age:");
        String age=sc.next();
        System.out.println("Please enter the birthday:");
        String birthday=sc.next();
        System.out.println("Please enter the subject:");
        String subject=sc.next();
        boolean result=teacherService.addStudent(id,name,age,birthday,subject);
        if(result==true){
            System.out.println("Add success");
        }else{
            System.out.println("No space to add");
        }
    }
    public void showTeacher(){
        teacherService.showTeacher();
    }
    public void deleteTeacher(){
        System.out.println("Pleanse enter the id:");
        String id=sc.next();
        boolean flag=false;
        boolean result=false;
        flag=teacherService.isExist(id);
        if(flag==true){
            result=teacherService.deleteTeacher(id);
        }else{
            System.out.println("no this teacher");
        }
        if(result==true){
            System.out.println("Delete success");
        }else{
            System.out.println("Delete fail");
        }
    }
    public void changeTeacher(){
        String id;
        boolean flag=false;
        while(true){
            System.out.println("Please enter the id:");
            id=sc.next();
            flag=teacherService.isExist(id);
            if(flag==false){
                System.out.println("No this student");
            }else{
                break;
            }
        }
        System.out.println("Please enter the name:");
        String name=sc.next();
        System.out.println("Please enter the age:");
        String age=sc.next();
        System.out.println("Please enter the birthday:");
        String birthday=sc.next();
        System.out.println("Please enter the subject:");
        String subject=sc.next();
        boolean result=false;
        result=teacherService.changeTeacher(id,name,age,birthday,subject);
        if(result==true){
            System.out.println("Change succsee");
        }else{
            System.out.println("change fall");
        }
    }
}
