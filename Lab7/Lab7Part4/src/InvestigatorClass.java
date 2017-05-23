import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 
 */

/**
 * @author den
 *
 */
public class InvestigatorClass {

	/**
	 * @param args
	 */
	static MysteryClass mystery;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mystery = new MysteryClass();
	
		Field[] fields = mystery.getClass().getDeclaredFields();
		for (int i=0; i<fields.length; i++){
			
			System.out.println("Field found " +fields[i].getName());
			System.out.println("Type of field " +fields[i].getType());
		}
		Method[] method = mystery.getClass().getDeclaredMethods();
		for (int i=0; i<method.length; i++){
			System.out.println("Method found "+method[i].getName());
			System.out.println("Return type of method "+method[i].getReturnType().getTypeName()); 
			System.out.println("The parametres to method "+method[i].getParameterTypes().getClass().getName());
			
		
		Class[] parameterTypes = method[i].getParameterTypes();
		for(int x=0; x<parameterTypes.length;x++){
			System.out.println(" " +parameterTypes[x].toString());
		}
		
		}
		System.out.println(" squered number 20 is "+mystery.publicMethod(20)); 
		}
	
}
