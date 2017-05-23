import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class FormFrame extends JFrame{
	
	private static JButton button;
	private static JLabel label ;
	private static JTextField field;

	
	 public FormFrame(){
		 
		 button = new JButton("submit");
		 field = new JTextField(10);
		
		 getContentPane().add(new RegisterPanel());
		
		
	
	}
	

	
	private class RegisterPanel extends JPanel {
		
		
		public RegisterPanel() {
			
		
			label = new JLabel("");
			add(field);
			add(button);    //or just this.add(name of the button);
			add(label);
			 button.addActionListener(new SubmitResponder());
			

		}
		
	}
	
private class SubmitResponder implements ActionListener{
	
	
		
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource()==button){
			
			label.setText("Submit Completed");
			field.setEnabled(false);
			setTitle("Works :)");
		}
	}
	
	}

		public static void main(String[] args) {
			FormFrame prog = new FormFrame();
					prog.setVisible(true);
					prog.setSize(200,200);
}

}
