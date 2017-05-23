/**
 * 
 */

/**
 * @author den
 *
 */
public class ThreadWithExtendsFixed extends Thread{
	private static String abcarray[] = {"A","B","C"};

	public ThreadWithExtendsFixed(){
			
	}
		public void run(){
		
			synchronized (abcarray) {
				
			
			for (int i = 0; i < abcarray.length; i++) {
				System.out.println(abcarray[i]);
			
			}
		}
			
			}
			

}
