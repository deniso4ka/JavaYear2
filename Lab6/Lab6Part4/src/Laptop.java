


public class Laptop extends Computer{

	

	String batteryLife;
	
	public Laptop(String manufacturer, double weight,double computerSpeed, double memory, double screenSize,String batteryLife){
		
		super(manufacturer,weight,computerSpeed,memory,screenSize);
		this.batteryLife = batteryLife;
	
	}
	
	@Override
	public String toString() {
		return "Laptop [batteryLife=" + batteryLife + "]"+ super.toString();
	}

	
	public String getbatteryLife(){
		
		return batteryLife;
		}

}

