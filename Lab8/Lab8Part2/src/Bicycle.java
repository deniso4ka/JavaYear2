public class Bicycle extends Vehicle{

  public Bicycle(int value) {
	this.value = value;
  }

  public String getDrivingInstructions() {

	String desc = "Driving instruction for " + this.getClass().getName();
	String instr =  "Seat on the bike and hold gas handle";
	

	return desc + "\n" + instr; 
  }
}

