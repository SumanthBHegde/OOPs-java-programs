package prg6;
import java.util.Scanner;
import java.lang.NullPointerException;

class InvalidAgeException extends Exception{
	public InvalidAgeException(String m) {
		super(m);
	}
}

class EmptyString extends Exception{
	public EmptyString(String m) {
		super(m);
	}
}

public class InvalidAgeDemo {

	public static void validateAge(int age) throws InvalidAgeException{
		if (age < 18) {
			throw new InvalidAgeException("The Age must be above 18, You are not elegible");
		}
		else {
			System.out.println("You are Elegible for Voting");
		}
	}
	
	static float divideNumbers(int dividend, int divisor) {
		if (divisor == 0) {
			throw new ArithmeticException("Divisor Cannot be Zero");
		}
		return dividend/divisor;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("Enter your choice: ");
			System.out.println("\n1.Validate Age\n2.Divide Numbers\n3.Array Index Out of Bounds Demo\n4.Calculate Length(Null pointer Exception)\n5.Array Index Out of Bounds Demo");
			int choice = scan.nextInt();
			try {
				switch(choice) {
				case 1:
					System.out.println("Enter the age to Check Elegibility: ");
					int age = scan.nextInt();
					validateAge(age);
					break;
				case 2:
					System.out.println("Enter the Dividend and Divisor to Divide: ");
					int dividend = scan.nextInt();
					int divisor = scan.nextInt();
					float res = divideNumbers(dividend, divisor);
					System.out.println("The Divided Result is : "+res);
					break;
				case 3: 
					int arr[] = new int[5];
					arr[5] = 23/5;
					System.out.println("The Divided Result is : "+arr[5]);
					break;
				case 4:
					String s = null;
					int l =s.length();
					System.out.println("The length of the string: "+l);
					break;
				case 5:
					String str = "HEllo";
					System.out.println("The character at index 8 "+str.charAt(7));
					break;
				default: flag=false;
				}
				
			}catch (InvalidAgeException e) {
				System.out.println("Age Error : "+e.getMessage());
			}
			catch (ArithmeticException e) {
				System.out.println("Divided by Zero Error : "+e.getMessage());
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Array Index Out of Bounds Error : "+e.getMessage());
			}
			catch(NullPointerException e) {
				System.out.println("Null Pointer Error : "+e.getMessage());
			}
			catch(StringIndexOutOfBoundsException e) {
				System.out.println("String Out of Bounds Error : "+e.getMessage());
			}
			catch(Exception e){
				System.out.println("Error: "+e);
			}finally {
				System.out.println("\nProgram Executed And Ended\n");
			}
		}
		scan.close();
	}

}
