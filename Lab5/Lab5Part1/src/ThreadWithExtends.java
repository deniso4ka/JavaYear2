/**
 * 
 */

/**
 * @author den
 *
 */
public class ThreadWithExtends extends Thread{
	private static String abcarray[] = {"A","B","C"};

	public ThreadWithExtends(){
		
		
	}
		public void run(){
		for (int i = 0; i < abcarray.length; i++) {
				System.out.println(abcarray[i]);
			}
	}
}
