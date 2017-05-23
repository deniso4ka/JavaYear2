import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author den
 *
 */
public class GUIWithInnerClass extends JFrame {
	
	
	
	JPanel panel = new JPanel();
	JButton button = new JButton();
	JLabel label = new JLabel();
	
		
		public GUIWithInnerClass(){
	
			getContentPane().add(panel);
			panel.add(button);
			panel.add(label);
			setSize(200,200);
			setVisible(true);
			setSize(200,200);
			button.addActionListener(new ButtonResponder());
	
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUIWithInnerClass program = new GUIWithInnerClass();
		
	
		
	}
	
	private class ButtonResponder implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource()==button){
				
				label.setText("Outer class label set by inner class"+this.getClass().getName());
				
				

				}
	}
	
		
	
	}
	
	
}

