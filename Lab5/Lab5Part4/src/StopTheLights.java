import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * 
 */

/**
 * @author den
 *
 */
public class StopTheLights extends JFrame implements Runnable,ActionListener {
	
	JButton button = new JButton("start");
	JButton button2 = new JButton("stop");
	JPanel panel = new JPanel();
	int value;
	
	public StopTheLights(){	
	
		
		setVisible(true);
		setSize(340,340);
		
		getContentPane().add(panel);
		panel.add(button);
		panel.add(button2);
		button.addActionListener(this);
		button2.addActionListener(this);
		
		
		   
	
		    	         
		    	 
}
	public void paint( Graphics g )
		{

  super.paint( g );

  g.drawRect (150, 50, 40, 100);
 drawBlankCircles(g);
		
		}
	public static void drawBlankCircles(Graphics g){
	
	
	 g.drawOval (160, 60, 20, 20);
	 g.drawOval(160, 80, 20, 20);
	 g.drawOval(160, 100, 20, 20);
	}
	public static synchronized void drawRed(Graphics g){
	
		 	
	 g.setColor(Color.RED);
	g.fillOval (160, 60, 20, 20);
	  g.setColor(Color.BLACK);
	 g.drawOval(160, 80, 20, 20);
	 g.setColor(Color.BLACK);
	 g.drawOval(160, 100, 20, 20);
	}
	public static synchronized void drawYellow(Graphics g){
		
	g.setColor(Color.BLACK);
	 g.drawOval (160, 60, 20, 20);
	 g.setColor(Color.YELLOW);
	 g.fillOval(160, 80, 20, 20);
	 g.setColor(Color.BLACK);
	  g.drawOval(160, 100, 20, 20);
	}
	public static synchronized void drawGreen(Graphics g){
		
		g.setColor(Color.BLACK);
	 g.drawOval (160, 60, 20, 20);
	 g.setColor(Color.BLACK);
	 g.drawOval(160, 80, 20, 20);
	 g.setColor(Color.GREEN);
	 g.fillOval(160, 100, 20, 20);
	}
		      
public synchronized void run(){
	
	
		
	
	
	Graphics g = this.getGraphics();
	try {
		Thread.sleep(2000);
		drawRed(g);
		drawBlankCircles(g);
		Thread.sleep(2000);
		validate();
		drawYellow(g);
		drawBlankCircles(g);
		Thread.sleep(2000);
		validate();
		drawGreen(g);
		drawBlankCircles(g);
		Thread.sleep(2000);
		
		validate();
		
		repaint();
	
	
	
	
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
		   
	
	
		   public void actionPerformed(ActionEvent e) {
			   
			   if(e.getSource() == button){
				 do{ 
				   run();
			   } while (value!=1);
				   //(new Thread(new StopTheLights())).start();   
				  
			   }

			   if(e.getSource() == button2){
				   value = 1; 
				   
				  
			   }

		
	}
	
	


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StopTheLights program = new StopTheLights();
		
		
	}
	
	
}
