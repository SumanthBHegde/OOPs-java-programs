package prg6;

class InvalidBalance extends Exception{
	public InvalidBalance(String m) {
		super(m);
	}
}

public class CheckBalance{
	public static boolean ValidBalance(double b) throws InvalidBalance{
		if (b <= 0) {
			throw new InvalidBalance("Balance Insufficient");
		}
		return true;
	}
}