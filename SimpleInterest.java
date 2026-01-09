package FirstPackage;
import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		double p, i, t, res;
		try (Scanner scan = new Scanner(System.in)) {
			//Get the Entries from the user
			System.out.println("Enter the principle: ");
			p = scan.nextDouble();
			
			System.out.println("Enter the principle interest: ");
			i = scan.nextDouble();
			
			System.out.println("Enter the time: ");
			t = scan.nextDouble();
		}
		
		res = (p*i*t)/100;
		System.out.println("The Simple Interest is : "+ res);
	}

}
