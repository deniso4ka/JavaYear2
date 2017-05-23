/**
 * 
 */
package reflections;

/**
 * @author den
 *
 */
public class ReflectionClass {



public ReflectionClass(){
	
	System.out.println(this.getClass().getName());   //getClass
	
	System.out.println(ReflectionClass.class.getName()); //.class
	
	
	try {
		
		Class printForName = ReflectionClass.class.forName("reflections.ReflectionClass");
		System.out.println(printForName.getClass().getName());
	} catch (ClassNotFoundException e) {
		e.printStackTrace();		
		
		// TODO Auto-generated catch block
	
	}
	
	
	
	
}



public static void main(String[] args) {
	
	ReflectionClass test = new ReflectionClass();
	
}



}