/**
 * 
 */

/**
 * @author den
 *
 */
public class TestTryCatchFinally {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		try {
			
			String s = null;
			s.toString();
			
		} 
		catch (NullPointerException e) {
			e.printStackTrace();
			
		
		}
		
		finally{
			
			System.out.println("exeption reached");
			
		}
	
		

	}

}
