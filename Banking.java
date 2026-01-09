package FirstPackage;
import java.util.Scanner;
import prg6.CheckBalance;

public class Banking {
	double balance = 0.0;
	static int accounts;
	String account_type, account_name, transaction_type;
	
//	Banking(){
//		balance = 0;
//		account_type = "savings";
//		accounts ++;
//	}
	
	Banking(String acc_name){
		account_name = acc_name;
		account_type = "savings";
		accounts ++;
	}
	
	Banking(double init_amount , String acc_name){
		this(acc_name);
		try {
			if(CheckBalance.ValidBalance(init_amount)) {
				balance += init_amount;
			}
		}catch(Exception e) {
			System.out.println("Insufficient Balance Error: "+e.getMessage());
		}
		
//		account_name = acc_name;
//		accounts ++;
	}
	
	Banking(double init_amount, String acc_name, String acc_type){
//		balance += init_amount;
		this(init_amount, acc_name);
		if (acc_type.equalsIgnoreCase("current")) {
			account_type = acc_type;
		}
	}
	
	void deposit(double amount){
		balance += amount;
		System.out.println(amount + " rupees has been credited.");
	}
	
	void deposit(double amount, String transaction_type){
//		balance += amount;
		deposit(amount);
		if (transaction_type.equalsIgnoreCase("Cash") || transaction_type.equalsIgnoreCase("Cheque")) {
			this.transaction_type = transaction_type;
			System.out.println("Transaction is : "+ transaction_type);
		}
	}
	
	void withdraw(double amount) {
		if (amount == balance && this.account_type.equalsIgnoreCase("current")) {
			balance = 0;
			System.out.println(amount + " rupees is debited. The Updated balance : "+ balance);
		}
		else if(amount >= balance) {
			System.out.println("Insufficient Balance");
		}
		else {
			balance = balance - amount;
			System.out.println(amount + " rupees is debited. The Updated balance : "+ balance);
		}
	}
	
	static void displayAccount() {
		System.out.println("The total number of accounts are : "+ accounts);
	}
	
	void display() {
		System.out.println("\nAccount Name: "+ account_name);
		System.out.println("Account Balance: "+ balance);
		System.out.println("Account Type: "+ account_type+"\n");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		//First User Object 
//		Banking firstUser = new Banking("First");
//		System.out.println("First User");
//		firstUser.display();
//		
//		//Second Dynamic User
//		System.out.println("Second User");
//		System.out.println("Enter Your Name: ");
//		String name = scan.next();
//		System.out.println("Enter Your Initial Deposit: ");
//		double amount = scan.nextDouble();
//		
//		Banking secondUser = new Banking(amount,name);
//		secondUser.display();
//		
//		System.out.println("Enter Your Deposit: ");
//		amount = scan.nextDouble();
//		System.out.println("Enter Your Transaction type : (Cash, Cheque)");
//		String type = scan.next();
//		secondUser.deposit(amount, type);
//		secondUser.display();
//		
//		System.out.println("Enter Amount to Withdraw: ");
//		amount = scan.nextDouble();
//		secondUser.withdraw(amount);

		boolean flag = true;
		System.out.println("Enter the Your Choices:");
		System.out.println("\n 1.Creating account \n2.Creating account with type \n3. Enter your Initial deposit \n4.Deposit \n5.Withdraw \nExit");
		
		while(flag) {
			int c = scan.nextInt();
			System.out.println("Enter Your Name: ");
			String name = scan.next();
			switch(c){
			case 1:
				Banking b1 = new Banking(name);
				b1.display();
				break;
			case 2:
				System.out.println("Enter Your Initial Deposit: ");
				double amount = scan.nextDouble();
				Banking b2 = new Banking(amount, name);
				b2.display();
				break;
			case 3:
				System.out.println("Enter Your Initial Deposit: ");
				amount = scan.nextDouble();
				System.out.println("Enter Your account type: ");
				String type = scan.next();
				Banking b3 = new Banking(amount, name);
				b3.display();
				break;
			case 4:
				System.out.println("Enter Your Initial Deposit: ");
				amount = scan.nextDouble();
				Banking b4 = new Banking(amount, name);
				System.out.println("Enter Amount to deposit: ");
				amount = scan.nextDouble();
				System.out.println("Enter Your Transaction type : (Cash, Cheque)");
				type = scan.next();
				b4.deposit(amount, type);
				b4.display();
				break;
			case 5:
				System.out.println("Enter Your Initial Deposit: ");
				amount = scan.nextDouble();
				Banking b = new Banking(amount, name);
				System.out.println("Enter Amount to withdraw: ");
				amount = scan.nextDouble();
				b.withdraw(amount);
				break;
			default:
				displayAccount();
				flag = false;	
			}
			
		}
		
		
		scan.close();
	}

}

//Enter the Your Choices:
//
//	 1.Creating account 
//	2.Creating account with type 
//	3. Enter your Initial deposit 
//	4.Deposit 
//	5.Withdraw 
//	Exit
//	3
//	Enter Your Name: 
//	test
//	Enter Your Initial Deposit: 
//	-9
//	Enter Your account type: 
//	savings
//	Insufficient Balance Error: Balance Insufficient
//
//	Account Name: test
//	Account Balance: 0.0
//	Account Type: savings
