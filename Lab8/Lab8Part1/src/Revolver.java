
public class Revolver implements Gun{
	
	private String serialNumber;
	
	
	public Revolver(String serialNumber){
		
		this.serialNumber=serialNumber;
		
	}
	
	
	public String getserialNumber(){
		
		
		return serialNumber;
	}
	
	
	public String getReloadInstructions() {

		String desc = "Reload for " + this.getClass().getName();
		String step1 =  "Pop open the revolving chamber and load bullets";
		String step2 = "Pop the revolving chamber back in place";

		return desc + "\n" + step1 + "\n" + step2;
	  }


}
