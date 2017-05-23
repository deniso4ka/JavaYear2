
public class Cannon implements Gun{
	
	private String serialNumber;
	
	
	public Cannon(String serialNumber){
		
		this.serialNumber=serialNumber;
		
	}
	
	
	public String getserialNumber(){
		
		
		return serialNumber;
	}
	
	
	public String getReloadInstructions() {

		String desc = "Reload for " + this.getClass().getName();
		String step1 =  "Pop open the Cannon and load bullets";
		String step2 = "and shoot";

		return desc + "\n" + step1 + "\n" + step2;
	  }


}

