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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

/**
 * Name: AdminActionsPanel <br>
 * This class creates the main window/frame used by
 * authorized administrator in order to manage particular
 * tasks (delete books and users and add books to the system).
 * @author DEN-ART
 * @version 1.2, date: 21.03.2015
 */
public class AdminActionsPanel extends JFrame implements ActionListener {

	//declare global variables
	private JPanel contentPane;
	private JButton logOffAdminButton;
	private JButton showBooksButton;
	private JButton addBooksButton;
	private JButton deleteBooksButton;
	private JButton showUsersButton;
	private JButton deleteUsersButton;
	private JMenuItem exitItem;
	private JMenuItem contactUsItem;
	public static String [] savingTitle ;
	public static String [] savingAuthorName;
	public static String [] savingAuthorSurname;
	public static String [] savingIsbn;
	public static String [] savingYearPublished;
	static int counter;

	/**
	 * Launch the application.
	 * @param args array of command-line arguments passed to this method
	 * @exception Exception - generates general exception
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminActionsPanel frame = new AdminActionsPanel();
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
	public AdminActionsPanel() {
		
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
		
		JLabel adminMssgLabel = new JLabel("YOU ARE LOGGED IN AS:");
		adminMssgLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		adminMssgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adminMssgLabel.setBackground(Color.YELLOW);
		adminMssgLabel.setOpaque(true);
		adminMssgLabel.setForeground(Color.RED);
		adminMssgLabel.setBorder(BorderFactory.createLineBorder(Color.RED,1));
		
		JLabel adminLoggedInLabel = new JLabel("ADMIN");
		adminLoggedInLabel.setOpaque(true);
		adminLoggedInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adminLoggedInLabel.setForeground(Color.RED);
		adminLoggedInLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		adminLoggedInLabel.setBorder(BorderFactory.createLineBorder(Color.RED,1));
		adminLoggedInLabel.setBackground(Color.YELLOW);
		
		JLabel booksLabel = new JLabel("Books:");
		booksLabel.setHorizontalAlignment(SwingConstants.CENTER);
		booksLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		booksLabel.setForeground(Color.BLACK);
		booksLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		JLabel usersLabel = new JLabel("Users:");
		usersLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usersLabel.setForeground(Color.BLACK);
		usersLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		usersLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		//create and set the buttons
		logOffAdminButton = new JButton("LOG OFF");
		logOffAdminButton.setOpaque(true);
		logOffAdminButton.setBackground(Color.RED);
		logOffAdminButton.setForeground(Color.WHITE);
		
		showBooksButton = new JButton("SHOW BOOKS");
		showBooksButton.setOpaque(true);
		showBooksButton.setForeground(Color.WHITE);
		showBooksButton.setBackground(Color.RED);
		showBooksButton.addActionListener(this);
		
		addBooksButton = new JButton("ADD BOOKS");
		addBooksButton.setOpaque(true);
		addBooksButton.setForeground(Color.WHITE);
		addBooksButton.setBackground(Color.RED);
		
		deleteBooksButton = new JButton("DELETE BOOKS");
		deleteBooksButton.setOpaque(true);
		deleteBooksButton.setForeground(Color.WHITE);
		deleteBooksButton.setBackground(Color.RED);
		
		showUsersButton = new JButton("SHOW USERS");
		showUsersButton.setOpaque(true);
		showUsersButton.setForeground(Color.WHITE);
		showUsersButton.setBackground(Color.RED);
		
		deleteUsersButton = new JButton("DELETE USERS");
		deleteUsersButton.setOpaque(true);
		deleteUsersButton.setForeground(Color.WHITE);
		deleteUsersButton.setBackground(Color.RED);
		
		//add action listeners
		deleteBooksButton.addActionListener(this);
		showUsersButton.addActionListener(this);
		deleteUsersButton.addActionListener(this);
		addBooksButton.addActionListener(this);
		logOffAdminButton.addActionListener(this);
		exitItem.addActionListener(this);
		
		//manage layout
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(horizontalLine, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(234)
					.addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
					.addGap(237))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(287, Short.MAX_VALUE)
					.addComponent(logOffAdminButton)
					.addGap(264))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(deleteBooksButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(addBooksButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(booksLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(showBooksButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(adminMssgLabel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(adminLoggedInLabel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(usersLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(showUsersButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
						.addComponent(deleteUsersButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
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
						.addComponent(adminLoggedInLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminMssgLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(booksLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(showBooksButton))
							.addGap(18)
							.addComponent(addBooksButton)
							.addGap(18)
							.addComponent(deleteBooksButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(usersLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(showUsersButton))
							.addGap(18)
							.addComponent(deleteUsersButton)))
					.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
					.addComponent(logOffAdminButton)
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
	 * This method connects to database to request details
	 * about the books.
	 * @exception it catches SQL Exception
	 */
	public static void SelectingFromDatabase() {
		
		Connection();
		int row =0;
		
		savingTitle = new String[10];
		savingAuthorName = new String[10];
		savingAuthorSurname = new String[10];
		savingIsbn = new String[10];
		savingYearPublished = new String[10];
		
		
		String host = "jdbc:mysql://localhost/library_project";
		String username = "deniss";
		String password ="0000";
		//String username = "root";
		//String password ="";
		
		try {
			Connection connect = DriverManager.getConnection(host, username, password);
			String query = "SELECT * FROM book";
			Statement stm = connect.createStatement();
			ResultSet rs = stm.executeQuery(query);
	
			while(rs.next()) {
				savingTitle[row] = rs.getString("Title");
				savingAuthorName[row] = rs.getString("AuthorName");
				savingAuthorSurname[row] = rs.getString("AuthorSurname");
				savingIsbn[row] = rs.getString("ISBN");
				savingYearPublished[row] = rs.getString("YearPublished");
			
				row++;
				counter=row;				
			}	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e1) {
		
		//exit menu item is clicked
		if (e1.getSource() == exitItem) {
			System.exit(0);
		}
		
		//show the list of books button is clicked
		if (e1.getSource() == showBooksButton) {
			SelectingFromDatabase();
			DisplayListOfBooksForAdmin.main(null);		
		}
		
		//add books button is clicked
		if (e1.getSource() == addBooksButton) {
			AddBook.main(null);   
			//setVisible(false);
		}
		
		//delete books button is clicked
		if (e1.getSource() == deleteBooksButton) {
			DeleteBook.main(null);
			//setVisible(false);
		}
		
		//show the list of students on the system button is clicked
		if (e1.getSource() == showUsersButton) {
			DisplayUsers.main(null);
			System.out.println("bhjsdfgashkf");
		}
		
		//delete students from the system button is clicked
		if (e1.getSource() == deleteUsersButton) {
			DeleteUser.main(null);
			//setVisible(false);
		}
		
		//logg off button is clicked
		if (e1.getSource() == logOffAdminButton) {
			//display the message about being logged off
			JOptionPane.showMessageDialog(this,
					  "You are about to log off!",
					  "Info Message",
					  JOptionPane.INFORMATION_MESSAGE);
		
		setVisible(false);
		StarterWindow.main(null);
		}
	}
}
