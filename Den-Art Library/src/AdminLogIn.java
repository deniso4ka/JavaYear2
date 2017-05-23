import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Name: AdminLogIn <br>
 * This class creates the main window/frame, which enables the
 * Administrator to log in onto the system and perform some
 * actions such as add or delete books from the system and 
 * delete users from the system.
 * @author DEN-ART
 * @version 1.1, date: 21.03.2015
 */
public class AdminLogIn extends JFrame implements ActionListener {

	//declare global variables
	private JPanel contentPane;
	private static JTextField adminIdTextField;
	private JTextField adminPasswordTextField;
	private JButton logInAdminButton;
	private JMenuItem exitItem;
	private JMenuItem contactUsItem;
	private JMenuItem studentPanelItem;
	static String [] admin;
	
	/**
	 * Launch the application.
	 * @param args array of command-line arguments passed to this method
	 * @exception Exception generates general exception
	 */
	public static void main(String[] args) {
			
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogIn frame = new AdminLogIn();
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor used to create the frame.
	 */
	public AdminLogIn() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		
		//create the menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
			//add menu items and menus to the menu bar
			JMenu openItem = new JMenu("Open");
			menuFile.add(openItem);
			studentPanelItem = new JMenuItem("Go to Student Login Panel");
			openItem.add(studentPanelItem);
			
			exitItem = new JMenuItem("Exit");
			menuFile.add(exitItem);
		
		JMenu menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		JMenu menuContact = new JMenu("About");
		menuBar.add(menuContact);
			//add menu items and menus to the contact menu
			contactUsItem = new JMenuItem("Contact Us");
			contactUsItem.setEnabled(false);
			menuContact.add(contactUsItem);
		
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		
		//add panel to the content pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//set labels (titles, fonts, colours, alignment)
		JLabel titleLabel = new JLabel("Den \u2013 Art \u00A9");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleLabel.setForeground(Color.RED);
		titleLabel.setOpaque(true);
		titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
		titleLabel.setBackground(Color.YELLOW);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel horizontalLine = new JLabel("");
		horizontalLine.setOpaque(true);
		horizontalLine.setBackground(Color.BLUE);
		
		JLabel adminLogInLabel = new JLabel("ADMINISTRATOR LOG IN");
		adminLogInLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		adminLogInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adminLogInLabel.setBackground(Color.YELLOW);
		adminLogInLabel.setOpaque(true);
		adminLogInLabel.setForeground(Color.RED);
		adminLogInLabel.setBorder(BorderFactory.createLineBorder(Color.RED,1));
		
		JLabel adminIdLabel = new JLabel("Admin ID:");
		adminIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adminIdLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		adminIdLabel.setForeground(Color.BLACK);
		adminIdLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		JLabel adminPasswordLabel = new JLabel("Password:");
		adminPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adminPasswordLabel.setForeground(Color.BLACK);
		adminPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		adminPasswordLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		adminIdTextField = new JTextField();
		adminIdTextField.setColumns(10);
		
		adminPasswordTextField = new JTextField();
		adminPasswordTextField.setColumns(10);
		
		//create and set the buttons
		logInAdminButton = new JButton("LOG IN");
		logInAdminButton.setOpaque(true);
		logInAdminButton.setBackground(Color.RED);
		logInAdminButton.setForeground(Color.WHITE);
		
		//add action listeners
		adminPasswordTextField.addActionListener(this);
		logInAdminButton.addActionListener(this);
		adminIdTextField.addActionListener(this);
		exitItem.addActionListener(this);
		studentPanelItem.addActionListener(this);
		
		//manage layout
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(adminIdLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(adminIdTextField))
						.addComponent(adminLogInLabel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(adminPasswordLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(adminPasswordTextField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(347, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(horizontalLine, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(234)
					.addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
					.addGap(237))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(283, Short.MAX_VALUE)
					.addComponent(logInAdminButton)
					.addGap(268))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(horizontalLine, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(adminLogInLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(adminIdLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(adminPasswordLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
					.addComponent(logInAdminButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	@Override
	public void actionPerformed(ActionEvent e4) {
		
		String adminPassword = adminPasswordTextField.getText();
		String adminId = adminIdTextField.getText();
		
		//student menu item is clicked
		if (e4.getSource() == studentPanelItem) {
			setVisible(false);
			LogInAndRegister.main(null);
		}
		
		//exit menu item is clicked
		if (e4.getSource() == exitItem) {
			System.exit(0);
		}
		
		//log in admin button is clicked
		if (e4.getSource() == logInAdminButton) {
				if(adminId.equals("Deniss") && adminPassword.equals("Ryga") ||
					adminId.equals("Torres") && adminPassword.equals("Barcelona")) {			
						System.out.println("You are right");
						setVisible(false);
						AdminActionsPanel.main(null);
						
						//admin logged in to the system
						JOptionPane.showMessageDialog(this,
							  "You are successfully logged in as Admin: " + adminId,
							  "Info Message",
							  JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					//incorrect log in or password entered by administrator
					JOptionPane.showMessageDialog(this,
						  "Incorrect Login or Password! ",
						  "Warning Message",
						  JOptionPane.WARNING_MESSAGE);
					
					System.out.println("Wrong password or login");
				}
		}
	}
}
