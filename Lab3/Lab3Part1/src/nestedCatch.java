import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 */

/**
 * @author den
 *
 */
public class nestedCatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		int [] someArray= new int[5];
		String urlAddress = "htp://www.tesco.com";
		
		try {
			
		System.out.println(someArray[6]);
			
		} 
		catch (ArrayIndexOutOfBoundsException a) {
			a.printStackTrace();
			System.out.println("1. Array is not that big");
			
			try {
				
				new URL(urlAddress);
				
			}
			
			catch (MalformedURLException b) {
				b.printStackTrace();
				System.out.println("2. Please make sure you entering url correctly");
			}
			
		}
		
		

	}

}
