/**
 * 
 */

/**
 * @author den
 *
 */
public class MobilePhone extends WalkieTalkie{
	@Override
	public String toString() {
		return "MobilePhone [networkName=" + networkName + "]" + super.toString();
	}


	private String networkName;
	
	public MobilePhone(String manufacturer, double weight, double rangeinKm,String networkName){
		
		super(manufacturer,weight,rangeinKm);
		this.networkName = networkName;
	
	}
	
	
	public String getnetworkName(){
		
		return networkName;
		}

}
