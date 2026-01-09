package FirstPackage;
import java.util.Scanner;

public class PrimeGen {
	
//	static Boolean checkPrime(int p) {
//		for(int j = 1; j < p/2; j++){
//			if (p % j == 0) {
//				System.out.println(p);
//				return true;
//			}
//		}
//		return false;
//	}

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			//Get the numbers to generate
			System.out.println("Enter a number to generate : ");
			int n = scan.nextInt();
			
			System.out.print("The Prime numbers are : ");
			for(int i = 1; i <=n; i++) {
//			if (checkPrime(i)) {
//				System.out.print(",\t"+i);
//			}
				boolean flag = false;
//			System.out.println("In Outer loop: "+ i);
				for(int j = 2; j <= i/2; j++){
//				System.out.println("In inner loop: "+ i);
//				System.out.println("In inner loop J: "+ j);
					if ((i % j) == 0) {
						flag = true;
//					System.out.println("In inner loop J: "+ j);
//					System.out.println("before break: "+ i);
						break;
					}
				}
//			System.out.println("Flag : "+flag + "  number " + i);
				if (flag == false){
					System.out.println("Result "+i);
				}
			}
		}
	}

}
