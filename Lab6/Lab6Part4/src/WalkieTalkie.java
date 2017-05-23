/**
 * 
 */

/**
 * @author den
 *
 */
public class WalkieTalkie extends HandHeldDevice{
private double rangeinKm;
	
	public WalkieTalkie(String manufacturer, double weight, double rangeinKm){
		
		super(manufacturer, weight);
		this.rangeinKm = rangeinKm;
	
	}
	
	
	


	@Override
	public String toString() {
		return "WalkieTalkie [rangeinKm=" + rangeinKm + "]"+ super.toString();
	}





	public double getrangeinKm(){
		
		return rangeinKm;
		}

}
