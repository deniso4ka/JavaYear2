
public class BankAccount {
	
	
	public BankAccount(){
				
	}
	public static void main(String[] args) {
		BankAccount account = new BankAccount();
	}

private static int balance = 10000;

public BankAccount(int balance){
	this.balance=balance;
	
}

public int getbalance() {


	
	return balance;
	
}

public synchronized static int  makeWithdrawn(int leftbalance){
	
	balance=balance-leftbalance;
	System.out.println("The current balance is "+balance);
	System.out.println("The name of the thread is" );
	
	return balance;
}
	
}
