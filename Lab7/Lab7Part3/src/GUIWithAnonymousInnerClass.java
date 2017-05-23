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
public class GUIWithAnonymousInnerClass extends JFrame{


	  
	public static void main(String[] args) {
		JButton button;
		JLabel label;
		JPanel panel;
		GUIWithAnonymousInnerClass prog = new GUIWithAnonymousInnerClass();
		button = new JButton("some text");
		label = new JLabel("something");
		panel = new JPanel();
		
		  prog.getContentPane().add(panel);
		  panel.add(label);
		  panel.add(button);
		  prog.setSize(300,300);
		  prog.setVisible(true);
		
		button.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (e.getSource()==button){
					
					label.setText("Outer class label set by inner class"+this.getClass().getName());
							}
		 }
		  });

		  
	}

}

