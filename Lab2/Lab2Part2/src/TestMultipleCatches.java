import java.lang.reflect.Array;

import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author den
 *
 */
public class TestMultipleCatches extends JFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String testArray[] = {"Name1","Name2","Name3"};
			System.out.println(testArray[3]);
			String s = "s";
			Integer.parseInt(s);
			 		
		} 
		
		catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Array out of bound");
		
		}
		
		catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Wrong Number format used");
		}
		
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("unrecognised error");
		}
		finally{
			System.out.println("Work done well!!!");
		}

	}

}
