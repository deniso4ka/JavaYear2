/**
 * 
 */
package cypher;

/**
 * @author den
 *
*/

/**
 * code breaking
 */
class CodeBreaker {
	
	public static void main(String[] args){
	
	
	String str = "start";
	
	String enc = Encoder.encode(str);
	String dec = Decoder.decode(str);
	
	System.out.println(enc);
	System.out.println(dec);

	
	}

}
