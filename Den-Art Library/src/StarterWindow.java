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
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JButton;

/**
 * Name: StarterWindow <br>
 * This class creates the main - welcome window for both
 * students and administrators.
 * @author DEN-ART
 * @version 1.0, date: 05.04.2015
 */
public class StarterWindow extends JFrame implements ActionListener {

	//declare global variables
	public static DisplayBooks frame;
	private JPanel contentPane;
	private JButton displayBooksCloseButton;
	private JButton studentButton;
	private JButton adminButton;
	private JMenuItem exitItem;
	private JMenuItem contactUsItem;
	private JMenuItem questionsItem;
	private JMenuItem studentPanelItem;
	private JMenuItem adminPanelItem;

	/**
	 * Launch the application.
	 * @param args array of command-line arguments passed to this method
	 * @exception Exception generates general exception
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StarterWindow frame = new StarterWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * This method creates the URL link to connect to
	 * the web page to find out library's rules and
	 * policies.
	 * @exception Malformed URL Exception may be caught
	 * @exception IO Exception may be caught
	 */
	public static void connectToUrl() {
		
	      try {
	          //set the page url in the String
	          String url = "http://www.itb.ie/Library/geninfo.html";
	          //open the webpage
	          java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
	        }
			catch (MalformedURLException e) { 
			    System.out.println("URL failed");
			}
	        catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	}

	/**
	 * Constructor used to create the frame.
	 */
	public StarterWindow() {
							
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		
		//create the menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
			//add menu items and menus to the file menu
			JMenu openItem = new JMenu("Open");
			menuFile.add(openItem);
			studentPanelItem = new JMenuItem("Go to Student Login Panel");
			openItem.add(studentPanelItem);
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
		
		JLabel displayBooksLabel = new JLabel("WELCOME TO DEN-ART LIBRARY");
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
		
		studentButton = new JButton("STUDENT");
		studentButton.setOpaque(true);
		studentButton.setForeground(Color.WHITE);
		studentButton.setBackground(Color.RED);
		
		adminButton = new JButton("ADMIN");
		adminButton.setOpaque(true);
		adminButton.setForeground(Color.WHITE);
		adminButton.setBackground(Color.RED);
				
		//add action listeners
		displayBooksCloseButton.addActionListener(this);
		studentButton.addActionListener(this);
		adminButton.addActionListener(this);
		exitItem.addActionListener(this);
		studentPanelItem.addActionListener(this);
		adminPanelItem.addActionListener(this);
		contactUsItem.addActionListener(this);
		questionsItem.addActionListener(this);
				 
		//manage layout
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(horizontalLine, GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(234)
					.addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
					.addGap(237))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(292, Short.MAX_VALUE)
					.addComponent(displayBooksCloseButton)
					.addGap(268))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(adminButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(studentButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(displayBooksLabel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(348, Short.MAX_VALUE))
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
					.addGap(18)
					.addComponent(studentButton)
					.addGap(18)
					.addComponent(adminButton)
					.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
					.addComponent(displayBooksCloseButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	@Override
	public void actionPerformed(ActionEvent e11) {
				
		//exit menu item is clicked
		if (e11.getSource() == exitItem) {
			System.exit(0);
		}
		
		//contact menu item is clicked
		if (e11.getSource() == contactUsItem) {
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
		
		if (e11.getSource() == questionsItem) {
			connectToUrl();
		}
		
		//student button or student panel item is clicked
		if (e11.getSource() == studentButton || e11.getSource() == studentPanelItem) {
			setVisible(false);
			LogInAndRegister.main(null);
		}
		
		//admin button is clicked
		if (e11.getSource() == adminButton || e11.getSource() == adminPanelItem) {
			setVisible(false);
			AdminLogIn.main(null);
		}
		
		//close the frame button is clicked
		if (e11.getSource() == displayBooksCloseButton) {
			setVisible(false);
		}
	}
}
