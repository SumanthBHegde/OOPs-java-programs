package prg5;

import java.util.Scanner;

interface PersonalDetails{
    void showPersonalDetails();
}

interface OfficialDetails{
    void showOfficialDetails();
}

class Employee implements PersonalDetails, OfficialDetails{

    String name, designation, department;
    int age, uid, empid;

    Employee(int uid, String name, int age, int empid, String designation, String department){
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.empid = empid;
        this.designation = designation;
        this.department = department;
    }

    @Override
    public void showPersonalDetails(){
        System.out.println("\nEmployee Personal Details");
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("UID : " + uid);
    }

    @Override
    public void showOfficialDetails(){
        System.out.println("\nEmployee Official Details");
        System.out.println("Employee ID : " + empid);
        System.out.println("Designation : " + designation);
        System.out.println("Department : " + department);
    }
}

class PersonalThread extends Thread{
    Employee emp;

    PersonalThread(Employee emp){
        this.emp = emp;
    }

    public void run(){
        emp.showPersonalDetails();
    }
}

class OfficialThread extends Thread{
    Employee emp;

    OfficialThread(Employee emp){
        this.emp = emp;
    }

    public void run(){
        emp.showOfficialDetails();
    }
}

public class EmployeesDriver {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Employee[] emp = new Employee[3];

        for(int i = 0; i < 3; i++){

            System.out.println("\nEnter details for Employee " + (i+1));

            System.out.println("Enter Name:");
            String name = scan.next();

            System.out.println("Enter Age:");
            int age = scan.nextInt();

            System.out.println("Enter UID:");
            int uid = scan.nextInt();

            System.out.println("Enter Employee ID:");
            int empid = scan.nextInt();

            System.out.println("Enter Designation:");
            String designation = scan.next();

            System.out.println("Enter Department:");
            String department = scan.next();

            emp[i] = new Employee(uid, name, age, empid, designation, department);
        }

        // Creating threads
        for(int i = 0; i < 3; i++){

            PersonalThread t1 = new PersonalThread(emp[i]);
            OfficialThread t2 = new OfficialThread(emp[i]);

            t1.start();
            t2.start();
        }

        scan.close();
    }
}
