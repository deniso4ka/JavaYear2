/**
 * 
 */

/**
 * @author den
 *
 */
public class HandHeldDevice extends ElectronicDevice{

private double weight;
	
	public HandHeldDevice(String manufacturer, double weight){
		
		super(manufacturer);
	this.weight=weight;
	
	}
	
	
	
	@Override
	public String toString() {
		return "HandHeldDevice [weight=" + weight + "]"+ super.toString();
	}



	public double getweight(){
		
		return weight;
		}
	
}
