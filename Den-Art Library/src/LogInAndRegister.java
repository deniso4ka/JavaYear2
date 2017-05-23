import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Name: LogInAndRegister <br>
 * This class creates the main window/frame, which is used to register
 * and log in the users of the system.
 * @author DEN-ART
 * @version 1.2, date: 14.03.2015
 */
public class LogInAndRegister extends JFrame implements ActionListener {

	//declare global variables
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField studentIdTextField;
	private JTextField passwordTextField;
	private JTextField reenterPasswordTextField;
	private JTextField registeredStudentIdTextField;
	private JTextField registeredStudentPasswordTextField;
	private JButton signUpButton1;
	private JButton logInUserButton;
	private JMenuItem exitItem;
	private JMenuItem contactUsItem;
	private JMenuItem questionsItem;
	private JMenuItem adminPanelItem;
	static String [] studentIdCheck;
	static String [] userPasswordCheck;
	private static int itemNumber;
	
	/**
	 * Launch the application.
	 * @param args array of command-line arguments passed to this method
	 * @exception Exception - generates general exception
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInAndRegister frame = new LogInAndRegister();
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
	public LogInAndRegister() {
		
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
			adminPanelItem = new JMenuItem("Go to Admin Login Panel");
			openItem.add(adminPanelItem);
			
			exitItem = new JMenuItem("Exit");
			menuFile.add(exitItem);
		
		JMenu menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
			//add menu items to the edit menu
			JMenuItem undoItem = new JMenuItem("Undo");
			undoItem.setEnabled(false);
			menuEdit.add(undoItem);
			JMenuItem redoItem = new JMenuItem("Redo");
			redoItem.setEnabled(false);
			menuEdit.add(redoItem);
			menuEdit.addSeparator();
			JMenuItem copyItem = new JMenuItem("Copy");
			copyItem.setEnabled(false);
			menuEdit.add(copyItem);
		
		JMenu menuContact = new JMenu("About");
		menuBar.add(menuContact);
			//add menu items and menus to the contact menu
			contactUsItem = new JMenuItem("Contact Us");
			menuContact.add(contactUsItem);
		
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
			//add rules items to the contact menu
			questionsItem = new JMenuItem("FAQ");
			menuHelp.add(questionsItem);
		
		//add the panel to the content pane
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
		
		JLabel newStudentLabel = new JLabel("NEW STUDENT");
		newStudentLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		newStudentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newStudentLabel.setBackground(Color.YELLOW);
		newStudentLabel.setOpaque(true);
		newStudentLabel.setForeground(Color.RED);
		newStudentLabel.setBorder(BorderFactory.createLineBorder(Color.RED,1));
		
		JLabel registeredStudentLabel = new JLabel("REGISTERED STUDENT");
		registeredStudentLabel.setOpaque(true);
		registeredStudentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registeredStudentLabel.setForeground(Color.RED);
		registeredStudentLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		registeredStudentLabel.setBorder(BorderFactory.createLineBorder(Color.RED,1));
		registeredStudentLabel.setBackground(Color.YELLOW);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		JLabel surnameLabel = new JLabel("Surname:");
		surnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		surnameLabel.setForeground(Color.BLACK);
		surnameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		surnameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		JLabel studentIdLabel = new JLabel("Student ID:");
		studentIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		studentIdLabel.setForeground(Color.BLACK);
		studentIdLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		studentIdLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setForeground(Color.BLACK);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		passwordLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		JLabel reenterPasswordLabel = new JLabel("Re-enter Password:");
		reenterPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reenterPasswordLabel.setForeground(Color.BLACK);
		reenterPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		reenterPasswordLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		JLabel registeredStudentIdLabel = new JLabel("Student ID:");
		registeredStudentIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registeredStudentIdLabel.setForeground(Color.BLACK);
		registeredStudentIdLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		registeredStudentIdLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		JLabel registeredStudentPassword = new JLabel("Password:");
		registeredStudentPassword.setHorizontalAlignment(SwingConstants.CENTER);
		registeredStudentPassword.setForeground(Color.BLACK);
		registeredStudentPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		registeredStudentPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		surnameTextField = new JTextField();
		surnameTextField.setColumns(10);
		
		studentIdTextField = new JTextField();
		studentIdTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		
		reenterPasswordTextField = new JTextField();
		reenterPasswordTextField.setColumns(10);
		
		registeredStudentIdTextField = new JTextField();
		registeredStudentIdTextField.setColumns(10);
		
		registeredStudentPasswordTextField = new JTextField();
		registeredStudentPasswordTextField.setColumns(10);
		
		//create and set the buttons
		signUpButton1 = new JButton("SIGN UP");
		signUpButton1.setOpaque(true);
		signUpButton1.setBackground(Color.RED);
		signUpButton1.setForeground(Color.WHITE);
		
		logInUserButton = new JButton("LOG IN");
		logInUserButton.setOpaque(true);
		logInUserButton.setForeground(Color.WHITE);
		logInUserButton.setBackground(Color.RED);
		
		//add action listeners
		logInUserButton.addActionListener(this);
		signUpButton1.addActionListener(this);
		exitItem.addActionListener(this);
		adminPanelItem.addActionListener(this);
		contactUsItem.addActionListener(this);
		questionsItem.addActionListener(this);
		
		//manage layout
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(studentIdLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(studentIdTextField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(347, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(347, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(reenterPasswordLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(reenterPasswordTextField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(347, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(nameTextField))
						.addComponent(newStudentLabel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(surnameLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(surnameTextField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(registeredStudentPassword, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(registeredStudentPasswordTextField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(registeredStudentLabel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(registeredStudentIdLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(registeredStudentIdTextField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(99)
					.addComponent(signUpButton1)
					.addPreferredGap(ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
					.addComponent(logInUserButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(105))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(horizontalLine, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(234)
					.addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
					.addGap(237))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(horizontalLine, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(registeredStudentLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(newStudentLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(surnameLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(surnameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(studentIdLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(studentIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(reenterPasswordLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(reenterPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(registeredStudentIdLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(registeredStudentIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(registeredStudentPassword, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(registeredStudentPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(signUpButton1)
						.addComponent(logInUserButton))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	/**
	 * This method calls the class forName (implements Driver interface).
	 * @exception Class Not Found Exception may be caught
	 */
	public static void Connection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");			
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method connects to database to add students to
	 * to the system.
	 * @param Name name of a student
	 * @param Surname second name of a student
	 * @param StudentId ID of a student
	 * @param Password password used to log in to the system
	 * @exception it catches SQL Exception
	 */
	public static void InsertionIntoDatabase(String StudentName, String StudentSurname, String StudentId, String StudentPassword) {
		
		Connection();
		
		String host = "jdbc:mysql://localhost/library_project";
		String username = "deniss";
		String password ="0000";
		//String username = "root";
		//String password ="";
	
		try {
			Connection connect = DriverManager.getConnection(host, username, password);
		
			PreparedStatement statement = (PreparedStatement) connect.prepareStatement("INSERT INTO user (StudentName, StudentSurname, StudentId, StudentPassword) VALUES(?,?,?,?)");
			statement.setString(1, StudentName);
			statement.setString(2, StudentSurname);
			statement.setString(3, StudentId);
			statement.setString(4, StudentPassword);
			statement.execute();
			statement.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * This method connects to database to request
	 * a student login and password used to successfully
	 * log in onto the system.
	 * @exception it catches SQL Exception
	 */
	public static void SelectingFromUserDatabase() {
		
		Connection();

		studentIdCheck = new String[10];
		userPasswordCheck= new String[10];
		
		String host = "jdbc:mysql://localhost/library_project";
		//String username = "deniss";
		//String password ="0000";
		String username = "root";
		String password ="";
		
		try {
			Connection connect = DriverManager.getConnection(host, username, password);
			String query = "SELECT * FROM user";	
			Statement stm = connect.createStatement();
			ResultSet rs = stm.executeQuery(query);
	
			while(rs.next()) {
				studentIdCheck[itemNumber] = rs.getString("StudentId");
				userPasswordCheck[itemNumber] = rs.getString("StudentPassword");
				System.out.println(studentIdCheck[itemNumber]);
				itemNumber++;			
			}	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}	
	
	@Override
	public void actionPerformed(ActionEvent e10) {
		
		String name = nameTextField.getText();
		String surname = surnameTextField.getText();
		String studentId = studentIdTextField.getText();
		String password = passwordTextField.getText();
		String reenterpassword = reenterPasswordTextField.getText();
		String studentIdChecker = registeredStudentIdTextField.getText();
		String userPasswordChecker = registeredStudentPasswordTextField.getText();
		int count = 0;
		
		//student menu item is clicked
		if (e10.getSource() == adminPanelItem) {
			setVisible(false);
			AdminLogIn.main(null);
		}
		
		//exit menu item is clicked
		if (e10.getSource() == exitItem) {
			setVisible(false);
		}
		
		//contact menu item is clicked
		if (e10.getSource() == contactUsItem) {
			//display contact information
			JOptionPane.showMessageDialog(this,
					  "Contact us at:\n" +
					  "1. tel:                0864563129\n" +
					  "2. tel:                0873462847\n" +
					  "3. email:          den_art@gmail.com\n" +
					  "4. facebook:   Den-Art Library Ltd",
					  "Info Message",
					  JOptionPane.INFORMATION_MESSAGE);
		}
		
		//library rules item is clicked
		//call the method from the StarterWindow class
		if (e10.getSource() == questionsItem) {
			StarterWindow.connectToUrl();
		}
		
		//login button clicked
		if (e10.getSource() == logInUserButton) {
			SelectingFromUserDatabase();
			
			for (int i=0; i < itemNumber; i++) {
				if (studentIdChecker.equals(studentIdCheck[i]) && userPasswordChecker.equals(userPasswordCheck[i])) {
					count=i;
					System.out.println(studentIdCheck[i] + ", " + userPasswordCheck[i]);
				}
			}
			
			if (studentIdChecker.equals("") || userPasswordChecker.equals("")) {
				//display the error dialog box
				JOptionPane.showMessageDialog(this,
						  "You cannot leave empty fields!",
						  "Warning Message",
						  JOptionPane.WARNING_MESSAGE);
			
				System.out.println("You cannot leave empty fields!");
			}
			else if (studentIdChecker.equals(studentIdCheck[count]) && userPasswordChecker.equals(userPasswordCheck[count])) {
				setVisible(false);
				SearchForBooks.main(null);
					//display the message that student is logged in
					JOptionPane.showMessageDialog(this,
							"You are successfully logged in as Student: " + studentIdChecker,
							"Info Message",
							JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				//display the error dialog box
				JOptionPane.showMessageDialog(this,
						  "Incorrect login or password!",
						  "Warning Message",
						  JOptionPane.WARNING_MESSAGE);
				
				System.out.println("Password or login details are incorrect");
			}			
		}
		
		//sign up button clicked
		if(e10.getSource() == signUpButton1) {
			
			if (!name.equals("") && !surname.equals("") && 
				!studentId.equals("") && !password.equals("") && !reenterpassword.equals("")) {
				
				if (!password.equals(reenterpassword)) {
					//display the error dialog box (passwords don't match)
					JOptionPane.showMessageDialog(this,
							  "Password don't match!",
							  "Warning Message",
							  JOptionPane.WARNING_MESSAGE);
					
					System.out.println("Password missmatch");	
				}
				else if (password.equals(reenterpassword) && !password.equals("")) {				
					InsertionIntoDatabase(name, surname, studentId, password);
					nameTextField.setText("");
					surnameTextField.setText("");
					studentIdTextField.setText("");
					passwordTextField.setText("");
					reenterPasswordTextField.setText("");
					
					//new student registered in the system
					JOptionPane.showMessageDialog(this,
							  "New student registered!",
							  "Info Message",
							  JOptionPane.INFORMATION_MESSAGE);
					
					System.out.println("New student registered!");
				}
			}
			else {				
				//display the error dialog box (fields empty)
				JOptionPane.showMessageDialog(this,
						  "All fields must be filled up!",
						  "Info Message",
						  JOptionPane.INFORMATION_MESSAGE);
					
				System.out.println("All fields must be filled up!");
			}			
		}
	}
}
