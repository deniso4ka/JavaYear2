import java.util.Vector;


public class TestVehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Vehicle> vehicles = new Vector<Vehicle>();

		Vehicle vec1 = new Car(1000);
		Vehicle vec2 = new Bicycle(50);
		Vehicle vec3 = new Car(2000);
		Vehicle vec4 = new Bicycle(60);
		Vehicle vec5 = new Car(3000);
		Vehicle vec6 = new Bicycle(70);
		Vehicle vec7 = new Car(4000);
		Vehicle vec8 = new Bicycle(80);
		Vehicle vec9 = new Car(5000);
		Vehicle vec10 = new Bicycle(90);
		vehicles.addElement(vec1);
		vehicles.addElement(vec2);
		vehicles.addElement(vec3);
		vehicles.addElement(vec4);
		vehicles.addElement(vec5);
		vehicles.addElement(vec6);
		vehicles.addElement(vec7);
		vehicles.addElement(vec8);
		vehicles.addElement(vec9);
		vehicles.addElement(vec10);

		
		
		for(int i=0;i<vehicles.size();i++) {
		    Vehicle currentVehicle = vehicles.elementAt(i);
		    System.out.println("++++++++++++++++++++++++++      "+(i+1)+"      +++++++++++++++++++++++++++++++");
		    System.out.println(currentVehicle.getDrivingInstructions());
		    System.out.println("The Vihicle price is "+currentVehicle.getvalue() +"$"+ "\n");
		    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		  }

	}

}
