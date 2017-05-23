/**
 * 
 */

/**
 * @author den
 *
 */
public class ElectronicDevice {
	
	private String manufacturer;
	
	public ElectronicDevice(String manufacturer){
		this.manufacturer = manufacturer;
		
	}
	
	public String getmanufacturer(){
		
	return manufacturer;
	}

	@Override
	public String toString() {
		return "ElectronicDevice [manufacturer=" + manufacturer + "]";
	}


}
