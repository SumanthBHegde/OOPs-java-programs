package prg5;
import java.util.Scanner;

interface PersonalDetails{
	public void showPersonalDetails();
}

interface OfficialDetails{
	public void showOfficialDetails();
}

class Employee implements PersonalDetails, OfficialDetails{
	String name, designation, department;
	int age,uid,empid;
	
	Employee(){
		
	}
	
	Employee(int uid, String name, int age, int empid, String designation, String department){
		this.uid = uid;
		this.name = name;
		this.age = age;
		this.empid = empid;
		this.designation = designation;
		this.department = department;
	}
	
	@Override
	public void showPersonalDetails() {
		System.out.println("Employee Personal Details:");
		System.out.println("Name : "+name);
		System.out.println("Age : "+age);
		System.out.println("Unique ID : "+uid);
	}
	
	@Override
	public void showOfficialDetails() {
		System.out.println("Employee Official Details:");
		System.out.println("Employee ID : "+empid);
		System.out.println("Designation : "+designation);
		System.out.println("Department : "+department);
	}
}

public class EmployeeDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter the details: ");
//		String name, designation, department;
//		int age, uid, empid;
//		System.out.println("Enter Name, Age, Unique ID : ");
//		name = scan.nextLine();
//		age = scan.nextInt();
//		uid = scan.nextInt();
//		System.out.println("Enter Employee Id, Designation, Department : ");
//		empid = scan.nextInt();
//		designation = scan.next();
//		department = scan.next();
//		Employee e1;
//		e1 = new Employee(uid,name,age, empid, designation, department);
//		int choice;
//		boolean flag=true;
//		while(flag) {
//			System.out.println("Enter the Choice: ");
//			System.out.println("1.Personal Details");
//			System.out.println("2.Official Details");
//			System.out.println("Enter any number to exit");
//			choice = scan.nextInt();
//			switch(choice) {
//				case 1: 
//					e1.showPersonalDetails();
//					break;
//				case 2:
//					e1.showOfficialDetails();
//					break;
//				default:
//					flag = false;
//			}
//		}
		
		Employee[] emp = new Employee[3];

		for(int i = 0; i < 3; i++) {
		    System.out.println("Enter the details for Employee " + (i+1) + " : ");
		
		    String name, designation, department;
		    int age, uid, empid;
		
		    System.out.println("Enter Name:");
		    name = scan.nextLine();
		
		    System.out.println("Enter Age:");
		    age = scan.nextInt();
		
		    System.out.println("Enter UID:");
		    uid = scan.nextInt();
		
		    System.out.println("Enter Employee ID:");
		    empid = scan.nextInt();
		
		    scan.nextLine(); // consume newline
		
		    System.out.println("Enter Designation:");
		    designation = scan.nextLine();
		
		    System.out.println("Enter Department:");
		    department = scan.nextLine();
		
		    emp[i] = new Employee(uid, name, age, empid, designation, department);
		}
		
		emp[0].showOfficialDetails();
		scan.close();

	}
}	
