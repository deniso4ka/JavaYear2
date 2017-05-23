
public class SemiAutomatic implements Gun{
	
	
	private String serialNumber;
	
	
	public SemiAutomatic(String serialNumber){
		
		this.serialNumber=serialNumber;
		
	}
	
	
	public String getserialNumber(){
		
		
		return serialNumber;
	}
	
	
	
	public String getReloadInstructions() {

		 String desc = "Reload for " + this.getClass().getName();
		 String step1 = "Remove magazine";
		 String step2 = "Pop bullets into magazine";
		 String step3 = "Replace magazine";



		return desc + "\n" + step1 + "\n" + step2+ "\n" + step3;
	  }

}
