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

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Name: SearchForBooks <br>
 * This class creates the GUI window for users to search
 * books of their interest. They are provided with a few options,
 * and they can borrow books, reset the search query or log off.
 * @author DEN-ART
 * @version 1.2, date: 14.03.2015
 */
public class SearchForBooks extends JFrame implements ActionListener {

	//declare global variables
	private JPanel contentPane;
	private JTextField bookTitleField;
	private JTextField authorNameTextField;
	private JTextField authorSurnameTextField;
	private JTextField isbnTextField;
	private JTextField yearPublishedTextField;
	public JTextField dueDateTextField;
	private JButton searchBookButton;
	private JButton logOffUserButton;
	private JButton rentButton;
	private JMenuItem exitItem;
	private JMenuItem contactUsItem;
	public static String [] savingTitle ;
	public static String [] savingAuthorName;
	public static String [] savingAuthorSurname;
	public static String [] savingIsbn;
	public static String [] savingYearPublished;
	static int counter;
	public static int storingRow;
	int answer;

	/**
	 * Launch the application.
	 * @param args array of command-line arguments passed to this method
	 * @exception Exception - generates general exception
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchForBooks frame = new SearchForBooks();
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
	public SearchForBooks() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		
		//create the menu bar and add menu items to it
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
		
		JLabel searchBookLabel = new JLabel("SEARCH FOR BOOK");
		searchBookLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		searchBookLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchBookLabel.setBackground(Color.YELLOW);
		searchBookLabel.setOpaque(true);
		searchBookLabel.setForeground(Color.RED);
		searchBookLabel.setBorder(BorderFactory.createLineBorder(Color.RED,1));
		
		JLabel bookTitleLabel = new JLabel("Title:");
		bookTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bookTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		bookTitleLabel.setForeground(Color.BLACK);
		bookTitleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		JLabel authorNameLabel = new JLabel("Author Name:");
		authorNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		authorNameLabel.setForeground(Color.BLACK);
		authorNameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		authorNameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		JLabel authorSurnameLabel = new JLabel("Author Surname:");
		authorSurnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		authorSurnameLabel.setForeground(Color.BLACK);
		authorSurnameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		authorSurnameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		JLabel isbnLabel = new JLabel("ISBN:");
		isbnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		isbnLabel.setForeground(Color.BLACK);
		isbnLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		isbnLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		JLabel yearPublishedLabel = new JLabel("Year Publidhed:");
		yearPublishedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		yearPublishedLabel.setForeground(Color.BLACK);
		yearPublishedLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		yearPublishedLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		JLabel dueDateLabel = new JLabel("Return by:");
		dueDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dueDateLabel.setForeground(Color.BLACK);
		dueDateLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		dueDateLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		//create and set text fields and password fields
		bookTitleField = new JTextField();
		bookTitleField.setColumns(10);
		
		authorNameTextField = new JTextField();
		authorNameTextField.setColumns(10);
		
		authorSurnameTextField = new JTextField();
		authorSurnameTextField.setColumns(10);
		
		isbnTextField = new JTextField();
		isbnTextField.setColumns(10);
		
		yearPublishedTextField = new JTextField();
		yearPublishedTextField.setColumns(10);
		
		dueDateTextField = new JTextField();
		dueDateTextField.setText("return date");
		dueDateTextField.setColumns(10);
		dueDateTextField.setEnabled(false);		//disable text field
		dueDateTextField.setHorizontalAlignment(SwingConstants.CENTER);
		
		//create and set the buttons
		searchBookButton = new JButton("SEARCH");
		searchBookButton.setOpaque(true);
		searchBookButton.setBackground(Color.RED);
		searchBookButton.setForeground(Color.WHITE);
		
		logOffUserButton = new JButton("LOG OFF");
		logOffUserButton.setOpaque(true);
		logOffUserButton.setForeground(Color.WHITE);
		logOffUserButton.setBackground(Color.RED);
				
		rentButton = new JButton("RENT");
		rentButton.setOpaque(true);
		rentButton.setForeground(Color.WHITE);
		rentButton.setBackground(Color.RED);
		
		//add action listeners
		searchBookButton.addActionListener(this);
		logOffUserButton.addActionListener(this);
		rentButton.addActionListener(this);
		exitItem.addActionListener(this);
		
		//manage layout
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(authorSurnameLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(authorSurnameTextField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(347, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(isbnLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(isbnTextField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(347, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(yearPublishedLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(yearPublishedTextField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(347, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(bookTitleLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(bookTitleField))
						.addComponent(searchBookLabel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(authorNameLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(authorNameTextField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
					.addComponent(dueDateLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(dueDateTextField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(99)
					.addComponent(searchBookButton)
					.addGap(95)
					.addComponent(rentButton, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
					.addComponent(logOffUserButton)
					.addGap(96))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(horizontalLine, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
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
					.addComponent(searchBookLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(bookTitleLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(bookTitleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(authorNameLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(authorNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(authorSurnameLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(authorSurnameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(isbnLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(isbnTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(yearPublishedLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(yearPublishedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(dueDateLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addComponent(dueDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchBookButton)
						.addComponent(rentButton)
						.addComponent(logOffUserButton))
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
	 * This method connects to database to request
	 * information on books.
	 * @exception it catches SQL Exception
	 */
	public static void SelectingFromDatabase() {
		
		Connection();
		
		int row = 0;
		
		savingTitle = new String[10];
		savingAuthorName = new String[10];
		savingAuthorSurname = new String[10];
		savingIsbn = new String[10];
		savingYearPublished = new String[10];
				
		String host = "jdbc:mysql://localhost/library_project";
		String username = "deniss";
		String password ="0000";
		//String username = "root";
		//String password = "";
		
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
				counter = row;	
			}							
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}			
	}

	@Override
	public void actionPerformed(ActionEvent e2) {
		
		String title = bookTitleField.getText();
		String authorName = authorNameTextField.getText();
		String authorSurname = authorSurnameTextField.getText();
		String isbn = isbnTextField.getText();
		String yearPublished = yearPublishedTextField.getText();
		
		//exit manu item is clicked
		if (e2.getSource() == exitItem) {
			System.exit(0);
		}
		
		//rent the book button is clicked
		if (e2.getSource() == rentButton) {
			if (answer == 1) {
				Calendar now = Calendar.getInstance();
				dueDateTextField.setText(+(now.get(Calendar.DATE) + 14) + "-" + 
										  (now.get(Calendar.MONTH) + 1) +  "-" +
										   now.get(Calendar.YEAR));		
				
				//display message whether the book has been rented or not
				int option = JOptionPane.showConfirmDialog(this,
							 "Do you want to borrow the book: " + title + "?\n" + 
							 "You should return the book by " + dueDateTextField.getText() + " \n" +
							 "Thank you for using our services!",
							 "Question Message",
							 JOptionPane.OK_CANCEL_OPTION,
							 JOptionPane.QUESTION_MESSAGE);
				
					//ask whether to print a receipt or not
					if (option == JOptionPane.OK_OPTION) {	
						int printChoice = JOptionPane.showConfirmDialog(this,
									  	  "Do you want to print the receipt?",
									  	  "Question Message",
									  	  JOptionPane.OK_CANCEL_OPTION,
									  	  JOptionPane.QUESTION_MESSAGE);
						//call the DenArtPrinter class to print a receipt if OK is clicked
						if (printChoice == JOptionPane.OK_OPTION) {
							setVisible(false);
							SearchForBooks.main(null);
							DenArtPrinter.main(null);
						}
						else {					
							setVisible(false);
							dueDateTextField.setText("");
							SearchForBooks.main(null);
						}
					}
					else {					
						setVisible(false);
						dueDateTextField.setText("");
						SearchForBooks.main(null);				
					}
				
				//clear the fields
				bookTitleField.setText("");
				authorNameTextField.setText("");
				authorSurnameTextField.setText("");
				isbnTextField.setText("");
				yearPublishedTextField.setText("");
			}
			else {
				//prompt user to enter the book to be borrowed
				JOptionPane.showMessageDialog(this,
						"You have to enter the title of the book!",
						"Info Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		//student log off button is clicked
		if(e2.getSource() == logOffUserButton) {
				//display the message about being logged off
				JOptionPane.showMessageDialog(this,
						  "You are about to log off!",
						  "Info Message",
						  JOptionPane.INFORMATION_MESSAGE);
			
			setVisible(false);
			//return to the login page
			LogInAndRegister.main(null);
		}
		
		//search button is clicked
		if (e2.getSource() == searchBookButton) {
			SelectingFromDatabase();
				
			for (int i = 0; i < counter; i++) {
				if (title.equals(savingTitle[i]) || 
					authorName.equals(savingAuthorName[i]) || 
					authorSurname.equals(savingAuthorSurname[i]) || 
					isbn.equals(savingIsbn[i]) || 
					yearPublished.equals(savingYearPublished[i])) {	
						storingRow = i;
						answer = 1;
						DisplayBooks.main(null);
				}
			}
		}		
	}
}