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

import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 * Name: DisplayBooks <br>
 * This class creates the main window/frame used to display books
 * stored in database.
 * @author DEN-ART
 * @version 1.1, date: 27.03.2015
 */
public class DisplayBooks extends JFrame implements ActionListener {

	//declare global variables
	public static DisplayBooks frame;
	private JPanel contentPane;
	private JTextArea displayBooksTextArea;
	private JButton displayBooksCloseButton;
	private JMenuItem exitItem;
	private JMenuItem contactUsItem;

	/**
	 * Launch the application.
	 * @param args array of command-line arguments passed to this method
	 * @exception Exception generates general exception
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayBooks frame = new DisplayBooks();
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
	public DisplayBooks() {
		
		String titleArray[] = SearchForBooks.savingTitle;
		String authorNameArray[] = SearchForBooks.savingAuthorName;
		String authorSurnameArray[] = SearchForBooks.savingAuthorSurname;
		String isbnArray[] = SearchForBooks.savingIsbn;
		String yearPublisherArray[] = SearchForBooks.savingYearPublished;
		int storingRow = SearchForBooks.storingRow;
							
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
		
		JLabel displayBooksLabel = new JLabel("REQUESTED BOOK:");
		displayBooksLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		displayBooksLabel.setHorizontalAlignment(SwingConstants.CENTER);
		displayBooksLabel.setBackground(Color.YELLOW);
		displayBooksLabel.setOpaque(true);
		displayBooksLabel.setForeground(Color.RED);
		displayBooksLabel.setBorder(BorderFactory.createLineBorder(Color.RED,1));
		
		//create and set the buttons
		displayBooksCloseButton = new JButton("CLOSE");
		displayBooksCloseButton.setOpaque(true);
		displayBooksCloseButton.setBackground(Color.RED);
		displayBooksCloseButton.setForeground(Color.WHITE);
		
		//create a text area
		displayBooksTextArea = new JTextArea();
		displayBooksTextArea.setBorder(BorderFactory.createLineBorder(Color.BLUE,1));
		
		//fix the first row
		if (storingRow == 0) {
			displayBooksTextArea.setText(titleArray[0] + ", " +
					 authorNameArray[0] + " " +
					 authorSurnameArray[0] + ", " +
					 isbnArray[0] + ", " +
					 yearPublisherArray[0]);
		}
		
		for (int i = 0; i < storingRow; i++) {
			displayBooksTextArea.setText(titleArray[storingRow] + ", " +
										 authorNameArray[storingRow] + " " +
										 authorSurnameArray[storingRow] + ", " +
										 isbnArray[storingRow] + ", " +
										 yearPublisherArray[storingRow]);
			//System.out.println("Row" + storingRow);
		}
		
		//add action listeners
		displayBooksCloseButton.addActionListener(this);
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
					.addComponent(displayBooksCloseButton)
					.addGap(268))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(displayBooksLabel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(347, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(displayBooksTextArea, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
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
					.addComponent(displayBooksLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(displayBooksTextArea, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(displayBooksCloseButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	@Override
	public void actionPerformed(ActionEvent e7) {
		
		//exit menu item is clicked
		if (e7.getSource() == exitItem) {
			System.exit(0);
		}
		
		//close the frame button is clicked
		if (e7.getSource() == displayBooksCloseButton) {
			displayBooksTextArea.setText("Thank you for borrowing book!!!");
			setVisible(false);
		}
	}
	
	public static void closeWindow() {
		//System.exit(0);
		frame.setVisible(false);
	}
}
