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
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Name: AddingBook <br>
 * This class creates the GUI window for administrator to add
 * books .
 * @author DEN-ART
 * @version 1.2, date: 14.03.2015
 */
public class AddBook extends JFrame implements ActionListener{

	//declare global variables
	private JPanel contentPane;
	private JTextField bookTitleField;
	private JTextField authorNameTextField;
	private JTextField authorSurnameTextField;
	private JTextField isbnTextField;
	private JTextField yearPublishedTextField;
	private JButton addBookButton;
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
					AddBook frame = new AddBook();
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
	public AddBook() {
		
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
		
		JLabel searchBookLabel = new JLabel("ADD BOOK");
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
				
		//create and set the buttons
		addBookButton = new JButton("ADD");
		addBookButton.setOpaque(true);
		addBookButton.setBackground(Color.RED);
		addBookButton.setForeground(Color.WHITE);
				
		closeWindowButton = new JButton("CLOSE");
		closeWindowButton.setOpaque(true);
		closeWindowButton.setForeground(Color.WHITE);
		closeWindowButton.setBackground(Color.RED);
		
		//add action listeners
		addBookButton.addActionListener(this);
		exitItem.addActionListener(this);
		closeWindowButton.addActionListener(this);
		
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
					.addContainerGap(347, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(99)
					.addComponent(addBookButton)
					.addGap(151)
					.addComponent(closeWindowButton)
					.addGap(256))
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
						.addComponent(yearPublishedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(addBookButton)
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
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * This method connects to database to add books.
	 * @param Title title of the book
	 * @param AuthorName name of the author of the book
	 * @param AuthorSurname second name of the author of the book
	 * @param ISBN isbn number of the book
	 * @param YearPublished the year that book was published
	 * @exception it catches SQL Exception
	 */
	public static void InsertingIntoDatabase(String Title, String AuthorName, String AuthorSurname, String ISBN, String YearPublished) {
		 
		Connection();

		String host = "jdbc:mysql://localhost/library_project";
		//String username = "deniss";
		//String password ="0000";
		String username = "root";
		String password ="";
		
		try {
			Connection connect = DriverManager.getConnection(host, username, password);
					
			PreparedStatement statement = (PreparedStatement) connect.prepareStatement("INSERT INTO book (Title, AuthorName, AuthorSurname, ISBN, YearPublished) VALUES(?,?,?,?,?)");
			statement.setString(1, Title);
			statement.setString(2, AuthorName);
			statement.setString(3, AuthorSurname);
			statement.setString(4, ISBN);
			statement.setString(5, YearPublished);
			statement.execute();
			statement.close();
							
			JOptionPane.showMessageDialog(null,
					  "New book added!",
					  "Info Message",
					  JOptionPane.INFORMATION_MESSAGE);
			
			System.out.println("New book added!");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	
	@Override
	public void actionPerformed(ActionEvent e3) {
		
		String Title = bookTitleField.getText();
		String AuthorName = authorNameTextField.getText();
		String AuthorSurname = authorSurnameTextField.getText();
		String ISBN = isbnTextField.getText();
		String YearPublished = yearPublishedTextField.getText();
		
		//exit menu item is clicked
		if (e3.getSource() == exitItem) {
			System.exit(0);
		}
		
		//close button is clicked
		if (e3.getSource() == closeWindowButton) {
			setVisible(false);
		}
		
		//add book button is clicked
		if(e3.getSource() == addBookButton) {
			
		   if (Title.equals("") &&
					AuthorName.equals("") &&
					AuthorSurname.equals("") &&
					ISBN.equals("") &&
					YearPublished.equals("")) {
						System.out.println("WRONGGGGG");
						
						//display the warning message (empty fields)
						JOptionPane.showMessageDialog(null,
								  "Fill out the fields!",
								  "Warning Message",
								  JOptionPane.WARNING_MESSAGE);
			}
			InsertingIntoDatabase(Title, AuthorName, AuthorSurname, ISBN, YearPublished);
			//make fields empty after the book has been added
			bookTitleField.setText("");
			authorNameTextField.setText("");
			authorSurnameTextField.setText("");
			isbnTextField.setText("");
			yearPublishedTextField.setText("");
		}		
	}
}

