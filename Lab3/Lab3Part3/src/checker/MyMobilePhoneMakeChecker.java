
package checker;

/**
 * @author den
 *
 */

/**
 * program allows to compare mobile fone model and if it is not the same then gives an error exception
 */
class MyMobilePhoneMakeChecker {
	
	public static void main(String[] args) {
		try{
			checkMyMobilePhoneMake("Vodafone");
		}
			catch (NotMyPhoneMakeException e) {
				System.out.println("wrong phone model");
			}
			
		}
	
public static void checkMyMobilePhoneMake(String inputPhonemake) throws NotMyPhoneMakeException{
		
	
	
		if(inputPhonemake == "Sony"){
			System.out.println("Model is correct");
		}
		else {
			throw new NotMyPhoneMakeException("You put the wrong mobile number");
		}
			
}
	

}
