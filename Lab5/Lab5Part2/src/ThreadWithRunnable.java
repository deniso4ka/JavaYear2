/**
 * 
 */

/**
 * @author den
 *
 */
public class ThreadWithRunnable implements Runnable{

	 static int numbers[]={1,2,3};	

	
public ThreadWithRunnable(){
		
	
	}
		public void run(){
			for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);	
				
			
		}
		
	}
		
}
