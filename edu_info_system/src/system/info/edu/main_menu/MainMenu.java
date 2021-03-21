package system.info.edu.main_menu;
import java.util.Scanner;
import system.info.edu.student_menu.StudentMenu;
public class MainMenu {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true) {
            //use loop to operate the system again and again;
            System.out.println("WELCOME TO EDUCATION SYSTEM");
            System.out.println("1.Student System");
            System.out.println("2.Teacher System");
            System.out.println("3.Exit");
            System.out.println("Please enter the number to use the function:");
            //this is the main menu's words;
            String choose=sc.next();
            switch(choose){
                case "1":
                    StudentMenu studentmenu=new StudentMenu();
                    studentmenu.start();
                    break;
                case "2":
                    System.out.println("Teacher System");
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter the correct number.");
            }
        }
    }
}
