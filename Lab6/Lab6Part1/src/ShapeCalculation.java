/**
 * 
 */

/**
 * @author den
 *
 */
public class ShapeCalculation {
	final static double pi =3.14159265;
	
	static double getVolumeOfCylinder(){
		double r =3;
		double h =2;
		double r2=r*r;
		double volumeOfCylinder=pi*r2*h;
		
		return volumeOfCylinder;
	}
	
	
	static double getVolumeofCube(){
		
		double volumeOfCube =pi*pi*pi;
		
		return volumeOfCube;
	}
	
	
static double getAreaOfSphere(){
		
	double r2=9;
		double AreaOfSphere =4*pi*r2;
		
		return AreaOfSphere;
	}
	
	

}
