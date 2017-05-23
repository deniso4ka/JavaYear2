import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author den
 *
 */
public class FullTranslationGUI extends JFrame implements ActionListener{

	Locale localeEN;
	Locale localeFR;
	ResourceBundle rs;
	JButton button;
	JComboBox<String> combo;
	JTextArea text = new JTextArea(15,20);
	JScrollPane scroll = new JScrollPane(text);
	int globalselected;
	Locale[] availableLocales = Calendar.getAvailableLocales();
	
	String allLocales;
	String[] languages = { "English", "French"};
	
	
	public FullTranslationGUI() {
		super("Translation");
		
		button = new JButton();
		francheLang(languages);
	
		getContentPane().add(button);
		getContentPane().add(scroll);
		getContentPane().add(combo);
		setLayout(new GridLayout(3,1));
		setVisible(true);
		setSize(500,500);
		button.addActionListener(this);
		combo.addActionListener(this);
		localeEN = new Locale("en", "IR");
		localeFR = new Locale("fr", "FR");
		rs = ResourceBundle.getBundle("ProgramProperties_en", localeEN);
		changeButtonText();
	
	}
	
	private void francheLang(String [] name){
	 combo = new JComboBox<String>(name);
	 
	}
	
	private void changeButtonText() {
		button.setText(rs.getString("button1"));
	}
	public static void main(String[] args) {
		FullTranslationGUI program = new FullTranslationGUI();
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()instanceof JComboBox){
			JComboBox jcm = (JComboBox) e.getSource();
			int selected = jcm.getSelectedIndex();
			globalselected=selected;
			
			if(selected == 0) {
				rs = ResourceBundle.getBundle("ProgramProperties_en", localeEN);
				combo.removeAllItems();
			combo.addItem(languages[0] = rs.getString("English"));
				combo.addItem(languages[1] = rs.getString("French"));
				changeButtonText();
			}
			 else if(selected == 1) {
				 rs = ResourceBundle.getBundle("ProgramProperties_fr", localeFR);
				 combo.removeAllItems();
				 combo.addItem(languages[0] = rs.getString("English"));
				combo.addItem(languages[1] = rs.getString("French"));
				
				 	changeButtonText();
			 }
					
					
					 
					
					 
				
			
		}
		else{
			if(e.getSource() == button && globalselected==1) {
				for(int i=0; i<availableLocales.length; i++){
					allLocales = allLocales + "\n" + availableLocales[i].getDisplayName(localeFR);
				text.setText(allLocales);
				}
			}
			if(e.getSource() == button && globalselected==0) {
				for(int i=0; i<availableLocales.length; i++){
				allLocales = allLocales + "\n" + availableLocales[i].getDisplayName(localeEN);
				text.setText(allLocales);
				}
			
		}
		
		
		}
		
			
			
	}

}
