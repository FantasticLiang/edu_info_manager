package system.info.edu.student_menu;
import java.util.Scanner;
import system.info.edu.student_service.StudentService;
import system.info.edu.student.Student;
public class StudentMenu {
    Scanner sc = new Scanner(System.in);
    private StudentService studentservice = new StudentService();

    public void start() {
        loop:
        while (true) {
            System.out.println("Welcome to Student System");
            System.out.println("1.Add Student Information");
            System.out.println("2.Delete Student Information");
            System.out.println("3.Change Student Information");
            System.out.println("4.Show Students Information");
            System.out.println("5.Exit");
            System.out.println("Please enter the number to use function:");
            String choose = sc.next();
            switch (choose) {
                case "1":
                    if (addStudent() == true) {
                        System.out.println("Add success!");
                    } else {
                        System.out.println("No space to add student");
                    }
                    break;
                case "2":
                    if (deleteStudent() == true) {
                        System.out.println("Delete success");
                    }
                    break;
                case "3":
                    if (changeStudent() == true) {
                        System.out.println("Change success");
                    }
                    break;
                case "4":
                    showStudent();
                    break;
                case "5":
                    break loop;
                default:
                    System.out.println("Please enter correct number");
            }
        }
    }

    public boolean addStudent() {
        String id;
        while (true) {
            System.out.println("Please enter the id:");
            id = sc.next();
            boolean flag = studentservice.isExist(id);
            if (flag == true) {
                System.out.println("Repeat id! Please enter the id again.");
            } else {
                break;
            }
        }
        System.out.println("Please enter the name:");
        String name = sc.next();
        System.out.println("Please enter the age:");
        String age = sc.next();
        System.out.println("Please enter the birthday:");
        String birthday = sc.next();
        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        return studentservice.addStudent(id, name, age, birthday);
    }

    public boolean deleteStudent() {
        System.out.println("please enter the id:");
        String id = sc.next();
        boolean flag = studentservice.isExist(id);
        boolean result = false;
        if (flag == true) {
            result = studentservice.deleteStudent(id);
        } else {
            System.out.println("No this student's id");
        }
        return result;
    }

    public boolean changeStudent() {
        System.out.println("Please enter the number:");
        String id = sc.next();
        boolean flag = studentservice.isExist(id);
        boolean result = false;
        if (flag == true) {
            System.out.println("Please enter the name:");
            String name = sc.next();
            System.out.println("Please enter the age:");
            String age = sc.next();
            System.out.println("Please enter the birthday:");
            String birthday = sc.next();
            result = studentservice.changeStudent(id, name, age, birthday);
        } else {
            System.out.println("No this student");
        }
        return result;
    }

    public void showStudent() {
        studentservice.showStudent();
    }
}

