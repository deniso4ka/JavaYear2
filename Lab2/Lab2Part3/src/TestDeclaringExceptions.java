import java.io.File;
import java.io.IOException;

/**
 * 
 */

/**
 * @author den
 *
 */
public class TestDeclaringExceptions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String s = "eman";
		String fileName ="file1";
		
		reverseString(s);
		try {				//using try catch block to avoid error (where file is not found).
			openFile(fileName);	//because of the exception the program can still be run
		} catch (IOException e) {
			
			e.printStackTrace();
			}
		
	}
		
	
	public static void reverseString(String s) throws NullPointerException{
		
		
		String reversedString = new StringBuffer(s).reverse().toString();
		System.out.println(reversedString);
		}
	
	
	public static void openFile(String fileName) throws IOException{
		
		File file = new File(fileName);
		file.exists();
		
	}
}
