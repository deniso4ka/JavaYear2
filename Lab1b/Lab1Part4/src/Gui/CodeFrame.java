package Gui;
import encoder.Encoding;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



/**
 * @author den
 *
 */
/**
 * 
 * JFrame with button and textfield where user can enter string and then press the butten and text will be incrypted
 *
 */
public class CodeFrame extends JFrame implements ActionListener {

	JButton button = new JButton("button");
	JTextField textArea2 = new JTextField("                 ");
	JTextField textArea1 = new JTextField("                 ");
	String str;

	
	public CodeFrame()  {
	super("codeframe");
	
	String str = "";
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JLabel label1 = new JLabel("Enter text to encode");
	JLabel label2 = new JLabel("The encoded text is");
	setLayout(new GridLayout(3,2));
	getContentPane().add(panel1);
	getContentPane().add(panel2);
	getContentPane().add(panel3);
	panel1.add(label1);
	panel1.add(textArea1);
	panel2.add(label2);
	panel2.add(textArea2);
	panel3.add(button);
	button.addActionListener(this);
	String decoded = Encoding.encode(str);
	textArea1.addActionListener(this);
	
	}
	/* 
	 * @see java.awt.event.ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	
	if(e.getSource() == button){
		str = textArea1.getText();
		System.out.println(Encoding.encode(str));
		textArea2.setText(Encoding.encode(str));
	}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CodeFrame codeFrame = new CodeFrame();
		          codeFrame.setVisible(true);
		      	  codeFrame.setSize(400,400);

	}

}
