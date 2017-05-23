public class Car extends Vehicle{

  public Car(int value) {
	this.value = value;
  }

  public String getDrivingInstructions() {

	String desc = "Driving instruction for " + this.getClass().getName();
	String instr =  "Seat in to the car and press the gas pedal";
	

	return desc + "\n" + instr; 
  }
}
