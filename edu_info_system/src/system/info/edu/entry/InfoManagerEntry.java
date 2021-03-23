package system.info.edu.entry;
import java.util.Scanner;
import system.info.edu.controller.StudentController;
public class InfoManagerEntry {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Welcom to Education System");
            System.out.println("1.Student System");
            System.out.println("2.Teacher System");
            System.out.println("3.Exit");
            System.out.println("Please Enter the number to use the function:");
            String choose=sc.next();
            switch(choose){
                case "1":
                    StudentController studentController=new StudentController();
                    studentController.start();
                    break;
                case "2":
                    System.out.println("Teacher System");
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Please enter correct numbers");
            }
        }
    }
}
