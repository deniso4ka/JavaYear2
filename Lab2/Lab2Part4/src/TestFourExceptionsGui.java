import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



/**
 * @author den
 *
 */

/**
 * 
 * 
 * program for testing four error exceptions by pressing on 4 different buttons
 *
 */
public class TestFourExceptionsGui extends JFrame implements ActionListener {
	
	JButton button1 = new JButton("Test IO Exeption");
	JButton button2 = new JButton("Test URL Exception");
	JButton button3 = new JButton("Test Null Pointer Exception");
	JButton button4 = new JButton("Test General Exception");
	
	public TestFourExceptionsGui(){
	
	super("Test Exeptions");

	
	JPanel panel = new JPanel();
	panel.add(button1);
	button1.addActionListener(this);
	panel.add(button2);
	button2.addActionListener(this);
	panel.add(button3);
	button3.addActionListener(this);
	panel.add(button4);
	button4.addActionListener(this);
	getContentPane().add(panel);
	setLayout(new GridLayout(2,2));
	setVisible(true);
	setSize(400,400);
	
}
	
	public void testException(String string, String filename, String url, boolean generalExceptionActivated){
		
		try {
			string.toCharArray(); //Null string potential error
			new FileReader(filename); //Unknown filename potential error
			new URL(url); //Badly written URL potential error
			if(generalExceptionActivated){ //Potential error
				this.clone();      //will be caught as a general error!
			}
			
			
		}
		
		catch (MalformedURLException e) {
		JOptionPane.showMessageDialog(this,"A URL has been badly written"+ e.getMessage());
		}
		catch (IOException e) {
		JOptionPane.showMessageDialog(this,"An IO Exeption has been caught"+ e.getMessage());
		}
		catch (NullPointerException e) {
		JOptionPane.showMessageDialog(this,"A Null Pointer Exception has been caught"+ e.getMessage());
		}
		catch (Exception e) {
		JOptionPane.showMessageDialog(this,"Some general unidentified Exception has been caught"+ e.getMessage());	
		}
		finally{
		JOptionPane.showMessageDialog(this,"The finally block has been called");	
		}
	
	}
	
	public void actionPerformed(ActionEvent eve) {
	
		if(eve.getSource() == button1){
		testException("Hi","Whatever.txt","http://www.itb.ie",false);
		}
		if (eve.getSource() == button2) {
		testException("Hi","Real.txt","ht//www.itb.ie",false);
		}
		if (eve.getSource() == button3) {
		testException(null,"Real.txt","http://www.itb.ie",false);
		}
		if (eve.getSource() == button4) {
		testException("Hi","Real.txt","http://www.itb.ie",true);
		}
	}

	
	public static void main(String[] args) {
		TestFourExceptionsGui program = new TestFourExceptionsGui();

	}

}
