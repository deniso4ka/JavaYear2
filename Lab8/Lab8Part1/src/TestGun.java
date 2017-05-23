import java.util.Vector;


public class TestGun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Gun> guns = new Vector<Gun>();
		Gun peaceMaker1 = new Revolver("B12345678");
		Gun peaceMaker2 = new SemiAutomatic("B12345777");
		Gun peaceMaker3 = new Cannon("B12355555");
		Gun peaceMaker4 = new Revolver("B6645678");
		Gun peaceMaker5 = new SemiAutomatic("B6612777");
		Gun peaceMaker6 = new Cannon("B6666123");
		Gun peaceMaker7 = new Revolver("B5555512");
		Gun peaceMaker8 = new SemiAutomatic("B2222777");
		Gun peaceMaker9 = new Cannon("B1111111115");
		Gun peaceMaker10 = new Revolver("B2222228");
		
		guns.addElement(peaceMaker1);
		guns.addElement(peaceMaker2);
		guns.addElement(peaceMaker3);
		guns.addElement(peaceMaker4);
		guns.addElement(peaceMaker5);
		guns.addElement(peaceMaker6);
		guns.addElement(peaceMaker7);
		guns.addElement(peaceMaker8);
		guns.addElement(peaceMaker9);
		guns.addElement(peaceMaker10);
		
		for(int i=0;i<guns.size();i++) {
		    Gun currentGun = guns.elementAt(i);
		    System.out.println("++++++++++++++++++++++++++      "+(i+1)+"      +++++++++++++++++++++++++++++++");
		    System.out.println("Reload instructions are "+currentGun.getReloadInstructions());
		    System.out.println("The serial number is "+currentGun.getserialNumber());
		    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		  }
		
	}

}
