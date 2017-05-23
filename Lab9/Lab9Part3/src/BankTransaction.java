
public class BankTransaction extends Thread{
	
	
	
	public BankTransaction(){
		
	}
	
	public synchronized void run(){
		
		
		BankAccount.makeWithdrawn(10);
		
	}

}
