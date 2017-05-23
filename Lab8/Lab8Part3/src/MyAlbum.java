import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class MyAlbum extends JFrame implements ActionListener {
	
	private JLabel label;
	private ImageIcon icon;
	Vector<AlbumItem> myImages = new Vector<AlbumItem>();
	private String someimage;
	private String somedescription;
	JButton button;
	JTextArea textArea;
	ImageIcon someIcon;
	JPanel panel;
	private int i;

	
	public MyAlbum(){
		
		
		
		button = new JButton("Next Image");
		button.addActionListener(this);
		textArea = new JTextArea(10,20);
	
		
		panel = new JPanel();
		getContentPane().add(panel);
		
		
		panel.add(button);
		
		
		
		setSize(300, 300);
		setVisible(true);
		
	
		AlbumItem vec1 = new FavouriteAnimal("image1.jpg","Butterfly");
		AlbumItem vec2 = new FavouriteAnimal("image2.jpg","Rabit");
		AlbumItem vec3 = new FavouriteAnimal("image3.jpg","Dog");
		AlbumItem vec4 = new FavouriteAnimal("image4.jpg","Lion");
		AlbumItem vec5 = new FavouriteAnimal("image5.jpg","Squirrel");
		
		AlbumItem vec6 = new FavouriteSport("image6.jpg","Football");
		AlbumItem vec7 = new FavouriteSport("image7.jpg","Jogging");
		AlbumItem vec8 = new FavouriteSport("image8.jpg","Voleyball");
		AlbumItem vec9 = new FavouriteSport("image9.jpg","Football Match");
		AlbumItem vec10 = new FavouriteSport("image10.jpg","kayaking");
		
		myImages.addElement(vec1);
		myImages.addElement(vec2);
		myImages.addElement(vec3);
		myImages.addElement(vec4);
		myImages.addElement(vec5);
		
		myImages.addElement(vec6);
		myImages.addElement(vec7);
		myImages.addElement(vec8);
		myImages.addElement(vec9);
		myImages.addElement(vec10);
	
	
		
	
	AlbumItem currentItem = myImages.elementAt(i);
	someimage=currentItem.getImage();
	somedescription=currentItem.getdiscription();
	System.out.println(someimage);
	System.out.println("before button pressed"+i);
	someIcon = new ImageIcon(someimage);
	label= new JLabel();
	panel.add(label);
	label.setIcon(someIcon);
	textArea.setText(somedescription);
	panel.add(textArea);

	    
	   
	  
	  //  System.out.println("The Vihicle price is "+currentItem.getdiscription());
	
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	
	 if(e.getSource() == button){
		 if(i<9){
		 i=i+1;
		 }
		 else{
			 i=0;
		 }
		 AlbumItem currentItem = myImages.elementAt(i);
			someimage=currentItem.getImage();
			somedescription=currentItem.getdiscription();
			someIcon = new ImageIcon(someimage);
			label.setIcon(someIcon);
			textArea.setText(somedescription);
			System.out.println(someimage);
			System.out.println("before button pressed"+i);
			
			
	
		
		// TODO Auto-generated method stub
 }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyAlbum prog = new MyAlbum();

	}

}
