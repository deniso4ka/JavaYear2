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
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 * Name: DisplayUsers <br>
 * This class creates the main window/frame used to display users
 * registered onto the system.
 * @author DEN-ART
 * @version 1.1, date: 27.03.2015
 */
public class DisplayUsers extends JFrame implements ActionListener {

	//declare global objects
	private JPanel contentPane;
	private static JButton displayUsersCloseButton;
	private static String studentId[];
	private static String studentName[];
	private static String studentSurname[];
	private static String studentPassword[];
	private static int itemNumber;
	private JTextArea displayUsersTextArea;
	private JMenuItem exitItem;

	/**
	 * Launch the application.
	 * @param args array of command-line arguments passed to this method
	 * @exception Exception generates general exception
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayUsers frame = new DisplayUsers();
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
	public DisplayUsers() {
		
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
		
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		
		//set the content pane
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
		
		JLabel displayUsersLabel = new JLabel("USERS REGISTERED ONTO THE SYSTEM:");
		displayUsersLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		displayUsersLabel.setHorizontalAlignment(SwingConstants.CENTER);
		displayUsersLabel.setBackground(Color.YELLOW);
		displayUsersLabel.setOpaque(true);
		displayUsersLabel.setForeground(Color.RED);
		displayUsersLabel.setBorder(BorderFactory.createLineBorder(Color.RED,1));
		
		//create and set the buttons
		displayUsersCloseButton = new JButton("CLOSE");
		displayUsersCloseButton.setOpaque(true);
		displayUsersCloseButton.setBackground(Color.RED);
		displayUsersCloseButton.setForeground(Color.WHITE);
		
		//create a text area
		displayUsersTextArea = new JTextArea();
		displayUsersTextArea.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
		
		//add action listeners
		displayUsersCloseButton.addActionListener(this);
		exitItem.addActionListener(this);
		
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
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(289, Short.MAX_VALUE)
					.addComponent(displayUsersCloseButton)
					.addGap(268))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(displayUsersLabel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(347, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(displayUsersTextArea, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(horizontalLine, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(displayUsersLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(displayUsersTextArea, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(displayUsersCloseButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		SelectingFromUserDatabase();
	
		for(int i=0; i < itemNumber; i++) {
			displayUsersTextArea.append(studentId[i].toString() + ", " +
										studentName[i].toString() + " " +
										studentSurname[i].toString() + ", " +
										studentPassword[i].toString()+"\n");
		}
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
	 * This method connects to database to request
	 * information about the students registered on
	 * the system.
	 * @exception it catches SQL Exception
	 */
	public static void SelectingFromUserDatabase() {
		
		Connection();
		
		studentId = new String[10];
		studentName= new String[10];
		studentSurname = new String[10];
		studentPassword = new String[10];
				
		String host = "jdbc:mysql://localhost/library_project";
		String username = "deniss";
		String password ="0000";
		//String username = "root";
		//String password ="";
		
		try {
			Connection connect = DriverManager.getConnection(host, username, password);
			String query = "SELECT * FROM user";			
			Statement stm = connect.createStatement();
			ResultSet rs = stm.executeQuery(query);
	
			while(rs.next()) {
				studentId[itemNumber] = rs.getString("StudentId");
				studentName[itemNumber] = rs.getString("StudentName");
				studentSurname[itemNumber] = rs.getString("StudentSurname");
				studentPassword[itemNumber] = rs.getString("StudentPassword");
				
				itemNumber++;				
			}	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void actionPerformed(ActionEvent e9) {
		
		//exit manu item is clicked
		if (e9.getSource() == exitItem) {
			System.exit(0);
		}
		
		//close the frame button is clicked
		if (e9.getSource() == displayUsersCloseButton) {			
			setVisible(false);
		}
	}
}

