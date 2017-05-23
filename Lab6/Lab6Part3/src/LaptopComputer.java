/**
 * 
 */

/**
 * @author den
 *
 */
public class LaptopComputer extends Computer{

	private String batteryLife;
	
	public LaptopComputer(double computerSpeed, double memory, double screenSize,String batteryLife){
		
		super(computerSpeed,memory,screenSize);
		this.batteryLife=batteryLife;
	
	}
	
	
	
	








	public String getbatteryLife(){
		
		return batteryLife;
		}
	
}
