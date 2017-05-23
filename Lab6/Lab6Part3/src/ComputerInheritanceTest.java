/**
 * 
 */

/**
 * @author den
 *
 */
public class ComputerInheritanceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Computer comp1 = new Computer(14.12,2000,16);
		Computer comp2 = new Computer(20.19,1450,12);
		LaptopComputer comp3 = new LaptopComputer(12.23,1200,13,"2 hours");
		LaptopComputer comp4 = new LaptopComputer(12.23,2500,10,"1 hour");
		
		
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
		System.out.println("First  Laptop");
		System.out.println("-------------------");
		System.out.println(" Computer speed is " +comp3.getcomputerSpeed()+" Ghz");
		System.out.println(" Computer memory is " +comp3.getmemory()+" Gb");
		System.out.println("Monitor size is "+comp3.getscreenSize()+" Inch");
		System.out.println("battery life is "+comp3.getbatteryLife());
		System.out.println("-----------------");
		System.out.println("Second  Laptop");
		System.out.println("-------------------");
		System.out.println(" Computer speed is " +comp4.getcomputerSpeed()+" Ghz");
		System.out.println(" Computer memory is " +comp4.getmemory()+" Gb");
		System.out.println("Monitor size is "+comp4.getscreenSize()+" Inch");
		System.out.println("Battery life is "+comp4.getbatteryLife());
	}

}
