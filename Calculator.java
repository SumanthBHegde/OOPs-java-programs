package FirstPackage;
import java.util.Scanner;

public class Calculator {
	double m,n;
	static double result;
	
	Calculator(double m, double n){
		this.m = m;
		this.n = n;
	}
	
	void sum() {
		result = m+n;
		System.out.println("The Summation is : "+result);
	}
	
	void diff() {
		result = m-n;
		System.out.println("The Summation is : "+result);
	}
	
	void mulit() {
		result = m*n;
		System.out.println("The Summation is : "+result);
	}

	void division() {
		if(n == 0) {
			throw new ArithmeticException("Divisor Cannot be Zero");
		}
		else {
			result = m/n;
			System.out.println("The Summation is : "+result);
		}
	}

	public static void main(String[] args) {
		
		
		
		try (Scanner scan = new Scanner(System.in)) {
			boolean flag = true;
			
			
			
			while(flag) {
				System.out.print("Enter two numbers to compute:");
				
				double m = scan.nextDouble();
				double n = scan.nextDouble();
				Calculator calc = new Calculator(m,n);
				
				
				System.out.print("Enter Your Choice : \n 1.Addition \n2.Subtraction \n3.Division \n4.Multiplication \n Others to exit \n");
				int ch = scan.nextInt();
				switch(ch) {
				case 1: 
					calc.sum();
					break;
				case 2:
					calc.diff();
					break;
				case 3:
					try {
					calc.division();
					}catch(ArithmeticException e) {
						System.out.println("Divided by Zero Error : "+e.getMessage());
					}
					break;
				case 4:
					calc.mulit();
				default :
					flag = false;
					System.out.println("Exiting Loop");
				}
			}
		}
	}

}
