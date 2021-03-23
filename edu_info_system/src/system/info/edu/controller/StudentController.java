package system.info.edu.controller;
import java.util.Scanner;
import system.info.edu.domain.Student;
import system.info.edu.service.StudentService;
public class StudentController {
    Scanner sc=new Scanner(System.in);
    private StudentService studentService=new StudentService();
    public void start(){
        loop: while(true){
            System.out.println("Welcome to Student System");
            System.out.println("1.Add Student");
            System.out.println("2.Delete Student");
            System.out.println("3.Update Student");
            System.out.println("4.Show Student");
            System.out.println("5.Exit");
            System.out.println("Please enter the number to use the function:");
            String choose=sc.next();
            switch(choose){
                case "1":
                    addStudent();
                    break;
                case "2":
                    deleteStudent();
                    break;
                case "3":
                    updateStudent();
                    break;
                case "4":
                    findAllStudent();
                    break;
                case "5":
                    break loop;
                default:
                    System.out.println("Please enter correct numbers");
            }
        }
    }
    public void addStudent(){
        String id;
        while(true){
            System.out.println("Please enter the id:");
            id=sc.next();
            boolean flag=studentService.isExist(id);
            if(flag){
                System.out.println("Repeat student, please enter another id:");
            }else{
                break;
            }
        }
        Student stu=inputInfo(id);
        boolean result=studentService.addStudent(stu);
        if(result==true){
            System.out.println("Add Success");
        }else{
            System.out.println("Add failed");
        }
    }
    public void findAllStudent(){
        Student[] stus=studentService.findAllStudent();
        if(stus==null){
            System.out.println("No student information");
            return;
        }else{
            System.out.println("Id Name Age Birthday");
            for(int i=0;i<stus.length;i++){
                if(stus[i]!=null) {
                    System.out.println(stus[i].getId() + " " + stus[i].getName() + " " + stus[i].getAge() + " " + stus[i].getBirthday());
                }
            }
        }
    }
    public void deleteStudent(){
        String id=inputId();
        studentService.deleteStudent(id);
        System.out.println("Delete Success");
    }
    public void updateStudent(){
        String id=inputId();
        Student stu=inputInfo(id);
        studentService.updateStudent(id,stu);
        System.out.println("Update success");
    }
    public String inputId(){
        String id;
        while(true){
            System.out.println("Please enter the id:");
            id=sc.next();
            boolean flag=studentService.isExist(id);
            if(flag){
                System.out.println("Repeat student, please enter another id:");
            }else{
                break;
            }
        }
        return id;
    }
    public Student inputInfo(String id){
        System.out.println("Please enter the name:");
        String name=sc.next();
        System.out.println("Please enter the age:");
        String age=sc.next();
        System.out.println("Please enter the birthday:");
        String birthday=sc.next();
        Student stu=new Student(id,name,age,birthday);
        return stu;
    }
}
