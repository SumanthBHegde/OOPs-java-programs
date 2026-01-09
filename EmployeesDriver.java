package prg5;
import java.util.Scanner;

public class EmployeesDriver {
//	static int count=0; 
//	public static Employee getDetails(Employee e, Scanner scan) {
//		System.out.println("Enter the details for Employee "+count+" : ");
//		String name, designation, department;
//		int age, uid, empid;
//		System.out.println("Enter Name, Age :");
//		name = scan.nextLine();
//		age = scan.nextInt();
//		uid = count;
//		System.out.println("Enter Employee Designation, Department : ");
//		designation = scan.next();
//		department = scan.nextLine();
//		empid = 100 + count;
//		e = new Employee(uid,name,age, empid, designation, department);
//		count++;
//		return e;
//	}

	public static void main(String[] args) {
		Employee[] emp = new Employee[3] ;
		Scanner scan = new Scanner(System.in);
		for(int i=1; i<3;i++) {
			System.out.println("Enter the details for Employee "+i+" : ");
			String name, designation, department;
			int age, uid, empid;
			System.out.println("Enter Name, Age , UID:");
			name = scan.nextLine();
			age = scan.nextInt();
			uid = scan.nextInt();
			System.out.println("Enter Employee Designation, Department, Empid : ");
			designation = scan.next();
			department = scan.nextLine();
			empid = scan.nextInt();
			emp[i] = new Employee(uid,name,age, empid, designation, department);
		}
		scan.close();
		emp[0].showOfficialDetails();
	}

}
