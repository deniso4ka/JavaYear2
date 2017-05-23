import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author den
 *
 */

/**
 * 
 * inputing string and pressing button after it displays the length of the string
 *
 */
public class stringMetering extends JFrame implements ActionListener {
	
	JButton stringLengthButton = new JButton("Get String Length");
	JTextField inputField = new JTextField(10);
	JLabel outputLabel = new JLabel("String length =");
	int size;
	String string=null;
	int message1;
	String message2;
	String string2;
	
	
	public stringMetering(){
		
		super("stringMetering");
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		getContentPane().add(panel1);
		getContentPane().add(panel2);
		getContentPane().add(panel3);
		panel1.add(outputLabel);
		panel2.add(inputField);
		panel3.add(stringLengthButton);
		setLayout(new GridLayout(2,2));
		stringLengthButton.addActionListener(this);
		inputField.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
			try{
				
				if(a.getSource() == stringLengthButton){
				
				string = inputField.getText();	
				if(string.length()==0) {
					string = null;
				}
				string.toCharArray();

				size = string.length();
				outputLabel.setText("String length = " +size);
					}
					
			}	
		catch(NullPointerException n){
				
			System.out.println("Null exception");
			if(message1 == JOptionPane.YES_OPTION){
			message1 = JOptionPane.showConfirmDialog(null,"Do you want to reenter?","", JOptionPane.YES_NO_OPTION);
			if(message1 == JOptionPane.YES_OPTION){
			message2 = JOptionPane.showInputDialog(null,"Please enter your string here");
			size = message2.length();
			JOptionPane.showMessageDialog(this, "String length = " +size);
			System.exit(0);
			}
			}
			if (message1 == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "Bue");
			System.exit(0);
			}
			
			}
			
			
			finally{
				System.out.print("Bue");
						}
			      }


	public static void main(String[] args) {
		
		stringMetering meterString = new stringMetering();
		meterString.setVisible(true);
		meterString.setSize(400,400);
	}

}
