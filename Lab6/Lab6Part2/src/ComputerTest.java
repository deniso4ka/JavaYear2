/**
 * 
 */

/**
 * @author den
 *
 */
public class ComputerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Computer comp1 = new Computer(25,2015,24);
		Computer comp2 = new Computer(3.4,1001,18);
		Computer comp3 = new Computer(1.5,80,15);
		
		System.out.println("-----------------");
		System.out.println("First Computer");
		System.out.println("-----------------");
		System.out.println(" Computer speed is " +comp1.getcomputerSpeed()+" Ghz");
		System.out.println(" Computer memory is " +comp1.getmemory()+" Gb");
		System.out.println("Monitor size is "+comp1.getscreenSize()+" Inch");
		System.out.println("-----------------");
		System.out.println("Second Computer");
		System.out.println("------------------");
		System.out.println(" Computer speed is " +comp2.getcomputerSpeed()+" Ghz");
		System.out.println(" Computer memory is " +comp2.getmemory()+" Gb");
		System.out.println("Monitor size is "+comp2.getscreenSize()+" Inch");
		System.out.println("-----------------");
		System.out.println("Third Computer");
		System.out.println("-------------------");
		System.out.println(" Computer speed is " +comp3.getcomputerSpeed()+" Ghz");
		System.out.println(" Computer memory is " +comp3.getmemory()+" Gb");
		System.out.println("Monitor size is "+comp3.getscreenSize()+" Inch");

	}

}
