package studentdbapp;
import java.util.Scanner;

public class Student{
    private String firstName;
    private String lastName;
    private int classification;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int courseCost = 600;
    private static int id = 1000;
    //constructor: prompt user to enter student's name and year
    public Student(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student's first name: ");
        this.firstName = scan.nextLine();
        System.out.println("Enter student's last name: ");
        this.lastName = scan.nextLine();
        System.out.print("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student's class level: ");
        this.classification = scan.nextInt();

        setStudentID();

        //Debug-TEST-System.out.println(firstName + " " + lastName + " " + classification + " " + studentID);
    }

    //generate an ID
    private void setStudentID(){
        //grade level + static ID
        id++;
        this.studentID = classification + "" + id;
    }
    //Enroll in courses
    public void enroll(){
        //get inside a loop, user hits 0
        do{
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner scan = new Scanner(System.in);
            String course = scan.nextLine();
            if (!course.equals("Q")){
                courses = courses + "\n  " + course;
                tuitionBalance += courseCost;
            } else{
                //System.out.println("BREAK");
                break;
            }
        } while (1 != 0);
        //debug-test-System.out.println("ENROLLED IN: " + courses);
        //debug test- System.out.println("TUITION BALANCE: " + tuitionBalance);
    }
    //View balance and pay tuition
    //view balance
    public void viewBalance(){
        System.out.println("Your balance is: $" + tuitionBalance);
    }
    //pay tuition
    public void payTuition(){
        viewBalance();
        System.out.print("Please enter your payment amount: $");
        Scanner scan = new Scanner(System.in);
        int payment = scan.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();

    }
    ///show status
    public String toString(){
        return "Name: " + firstName + " " + lastName + 
        "\nStudent ID: "+ studentID + 
        "\nLevel: " + classification + 
        "\nCourses Enrolled: " + courses + 
        "\nBalace: $" + tuitionBalance;
    }
    
}