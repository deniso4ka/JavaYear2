import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ThreeButtons extends JFrame implements ActionListener {

	Locale localeEN;
	Locale localeFR;
	Locale localeLV;
	JLabel label;
	JButton button1;
	JButton button2;
	JButton button3;
	
	ResourceBundle rs;
	
	public ThreeButtons(){
		
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		label = new JLabel();
		localeEN = new Locale("en", "IR");
		localeFR = new Locale("fr", "FR");
		localeLV = new Locale("lv", "LV");
		getContentPane().add(button1);
		getContentPane().add(button2);
		getContentPane().add(button3);
		getContentPane().add(label);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
	
		
		
		setLayout(new GridLayout(4, 1));
		rs = ResourceBundle.getBundle("ProgramResource", localeEN);
		
		
		changeButonText();
		
	}
	private void changeButonText() {
		button1.setText(rs.getString("message1"));
		button2.setText(rs.getString("message2"));
		button3.setText(rs.getString("message3"));
		label.setText(rs.getString("message4"));
		
		setVisible(true);
		setSize(200,200);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == button1) {
			rs = ResourceBundle.getBundle("ProgramResource", localeEN);
			changeButonText();


		}
		if (e.getSource() == button2) {
			rs = ResourceBundle.getBundle("ProgramResource", localeFR);
			changeButonText();


		}
		if (e.getSource() == button3) {
			rs = ResourceBundle.getBundle("ProgramResource", localeLV);
			changeButonText();


		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeButtons prog = new ThreeButtons();

	}

}
