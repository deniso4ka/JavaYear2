import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Name: DeleteUser <br>
 * This class creates the main window/frame, which enables the
 * Administrator to delete user.
 * @author DEN-ART
 * @version 1.1, date: 21.03.2015
 */
public class DeleteUser extends JFrame implements ActionListener {

	//declare global variables
	private JPanel contentPane;
	private JTextField studentIdTextField;
	private JButton deleteUserButton;
	private JButton closeWindowButton;
	private JMenuItem exitItem;
	private JMenuItem contactUsItem;

	/**
	 * Launch the application.
	 * @param args array of command-line arguments passed to this method
	 * @exception Exception - generates general exception
	 */
	public static void main(String[] args) {
			
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUser frame = new DeleteUser();
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
	public DeleteUser() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		
		//create the menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
			//add exit menu item to file menu
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
		
		//set content pane
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
		
		JLabel adminLogInLabel = new JLabel("Delete User");
		adminLogInLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		adminLogInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adminLogInLabel.setBackground(Color.YELLOW);
		adminLogInLabel.setOpaque(true);
		adminLogInLabel.setForeground(Color.RED);
		adminLogInLabel.setBorder(BorderFactory.createLineBorder(Color.RED,1));
		
		JLabel studentIdLabel = new JLabel("StudentId:");
		studentIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		studentIdLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		studentIdLabel.setForeground(Color.BLACK);
		studentIdLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		studentIdTextField = new JTextField();
		studentIdTextField.setColumns(10);
		
		//create and set the buttons
		deleteUserButton = new JButton("DELETE");
		deleteUserButton.setOpaque(true);
		deleteUserButton.setBackground(Color.RED);
		deleteUserButton.setForeground(Color.WHITE);
		
		closeWindowButton = new JButton("CLOSE");
		closeWindowButton.setOpaque(true);
		closeWindowButton.setForeground(Color.WHITE);
		closeWindowButton.setBackground(Color.RED);
		
		//add action listeners
		deleteUserButton.addActionListener(this);
		studentIdTextField.addActionListener(this);
		exitItem.addActionListener(this);
		closeWindowButton.addActionListener(this);
		
		//manage layout
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(horizontalLine, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(234)
					.addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
					.addGap(237))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(deleteUserButton)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(studentIdLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(studentIdTextField))
							.addComponent(adminLogInLabel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)))
					.addGap(68)
					.addComponent(closeWindowButton, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(200, Short.MAX_VALUE))
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
						.addComponent(studentIdLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(studentIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(163)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(deleteUserButton)
						.addComponent(closeWindowButton))
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
	 * This method connects to database in order to
	 * remove students from the system.
	 * @param studentId id of the student to be deleted
	 * @exception it catches SQL Exception
	 */
	public static void DeletingFromDatabase(String studentId) {
		
		Connection();
			
		String host = "jdbc:mysql://localhost/library_project";
		String username = "deniss";
		String password = "0000";
		//String username = "root";
		//String password = "";
		
		try {
			Connection connect = DriverManager.getConnection(host, username, password);					
			PreparedStatement statement = connect.prepareStatement("DELETE FROM user WHERE StudentId = ?");			
			statement.setString(1, studentId);
			statement.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void actionPerformed(ActionEvent e6) {
		
		String studentId = studentIdTextField.getText();
		
		//exit menu item is clicked
		if (e6.getSource() == exitItem) {
			System.exit(0);
		}
		
		//close the frame button is clicked
		if (e6.getSource() == closeWindowButton) {
			setVisible(false);
		}
		
		//remove the student from the system is clicked
		if (e6.getSource() == deleteUserButton) {	
			if (studentId.equals("")) {
				//field must contain the student Id
				JOptionPane.showMessageDialog(this,
						  "Enter a student ID to remove a student!",
						  "Info Message",
						  JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				DeletingFromDatabase(studentId);			
				//info about unregistered students
				JOptionPane.showMessageDialog(this,
						  "Student removed from the system!",
						  "Info Message",
						  JOptionPane.INFORMATION_MESSAGE);
			
				studentIdTextField.setText("");
				setVisible(false);
			}
		}		
	}
}

