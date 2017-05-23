import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author den
 *
 */
public class ButtonTranslator extends JFrame implements ActionListener {

	ResourceBundle rs;
	JButton button4 = new JButton();;
	JButton button3 = new JButton();
	JButton button2 = new JButton();
	JButton button1 = new JButton();

	Locale localeEN;
	Locale localeFR;

	public ButtonTranslator() {
		super("button translator");

		localeEN = new Locale("en", "IR");
		localeFR = new Locale("fr", "FR");
		rs = ResourceBundle.getBundle("ProgramResource", localeEN);

		changeButonText();
		getContentPane().add(button1);
		getContentPane().add(button2);
		getContentPane().add(button3);
		getContentPane().add(button4);
		setLayout(new GridLayout(4, 1));
		button4.addActionListener(this);
	}

	private void changeButonText() {
		button1.setText(rs.getString("message1"));
		button2.setText(rs.getString("message2"));
		button3.setText(rs.getString("message3"));
		button4.setText(rs.getString("message4"));
	}

	public void actionPerformed(ActionEvent e) {
		

		if (e.getActionCommand().equals("translate to french")) {
			rs = ResourceBundle.getBundle("ProgramResource", localeFR);
			changeButonText();


		} else {
			rs = ResourceBundle.getBundle("ProgramResource", localeEN);
			changeButonText();

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ButtonTranslator program = new ButtonTranslator();
		program.setVisible(true);
		program.setSize(300, 300);

	}

}
