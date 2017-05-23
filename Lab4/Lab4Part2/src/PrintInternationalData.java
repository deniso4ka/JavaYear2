import java.util.Date;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.text.DateFormatter;


/**
 * @author den
 *
 */
/**
 * program out prints currancy,days of the week, and todays date of latvia,ireland and italy 
 */
public class PrintInternationalData {

	
	public static void main(String[] args) {
	
		Locale locale1 = new Locale("en","IE");
		Locale locale2 = new Locale("it","IT");
		Locale locale3 = new Locale("lv","LV");
		
		NumberFormat num1 = NumberFormat.getCurrencyInstance(locale1);
		NumberFormat num2 = NumberFormat.getCurrencyInstance(locale2);
		NumberFormat num3 = NumberFormat.getCurrencyInstance(locale3);
		
		DateFormatSymbols dfs1 = new DateFormatSymbols(locale1);
		DateFormatSymbols dfs2 = new DateFormatSymbols(locale2);
		DateFormatSymbols dfs3 = new DateFormatSymbols(locale3);
		System.out.print("here is what it does"+ dfs1);
		System.out.print("here is what it does"+ dfs2);
		System.out.print("here is what it does"+ dfs3);
		String dayName1[] = dfs1.getWeekdays();
		String dayName2[] = dfs2.getWeekdays();
		String dayName3[] = dfs3.getWeekdays();
		Double price=2.59;
		
		String dateOut;
		String dateOut2;
		String dateOut3;
		DateFormat dateFormatter;
		DateFormat dateFormatter2;
		DateFormat dateFormatter3;
		System.out.println("_______________________________");
		System.out.println("Ireland");
		System.out.println("_______________________________");
		for (int i = 0; i < 7; i++) {
			System.out.println(dayName1[i+1]);
			}
		dateFormatter = DateFormat.getDateInstance(DateFormat.FULL, locale1);
		Date today = new Date();
		dateOut = dateFormatter.format(today);
		System.out.println(dateOut + " " + locale1.toString());
		System.out.println("The milk price is  "+num1.format(price));
		
		System.out.println("_______________________________");
		
		System.out.println("Italy");
		System.out.println("_______________________________");

		for (int x = 0; x < 7; x++) {
			System.out.println(dayName2[x+1]);
		}
		dateFormatter2 = DateFormat.getDateInstance(DateFormat.FULL, locale2);
		Date today2 = new Date();
		dateOut2 = dateFormatter2.format(today2);
		System.out.println(dateOut2 + " " + locale2.toString());
		System.out.println("The milk price is "+num2.format(price));
		System.out.println("_______________________________");
		System.out.println("latvia");
		System.out.println("_______________________________");
		
		for (int z = 0; z < 7; z++) {
			System.out.println(dayName3[z+1]);
		}
		dateFormatter3 = DateFormat.getDateInstance(DateFormat.FULL, locale3);
		Date today3 = new Date();
		dateOut3 = dateFormatter3.format(today3);
		System.out.println(dateOut3 + " " + locale3.toString());
		System.out.println("The milk price is "+num3.format(price));
		System.out.println("_______________________________");
	}

}
