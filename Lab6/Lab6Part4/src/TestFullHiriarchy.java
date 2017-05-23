import java.util.Vector;

/**
 * 
 */

/**
 * @author den
 *
 */
public class TestFullHiriarchy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 Vector<Object>ElectDevice = new Vector<Object>();

		ElectronicDevice electDev = new ElectronicDevice("DEVICE");
		HandHeldDevice handDev = new HandHeldDevice("Name2",1800);
		Computer comp = new Computer("DifferentName",1200,111,222,333);
		Laptop lap = new Laptop("Sony", 3000, 1300, 2300, 15, "1 hour");
		WalkieTalkie wk = new WalkieTalkie("Nokia", 5000, 2000);
		MobilePhone mp = new MobilePhone("Nokia", 4000, 100, "Tele2");
		System.out.println("-------------------------------------");
		
		System.out.println("-------------------------------------");
		
		ElectDevice.add(electDev);  //adding objects to vector
		ElectDevice.add(handDev);
		ElectDevice.add(comp);
		ElectDevice.add(lap);
		ElectDevice.add(wk);
		ElectDevice.add(mp);
		
		for(int i=0; i<ElectDevice.size(); i++){
			
			
			
			System.out.println(ElectDevice.elementAt(i).toString());
			System.out.println("-------------------------------------");
			
			
		}
		
		
	}

}
