import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.print.*;

/**
 * Name: DenArtPrinter <br>
 * This class enables students to print receipts
 * of the borrowed books.
 * @author DEN-ART
 * @version 1.0, date: 5.04.2015
 */
public class DenArtPrinter implements Printable, ActionListener {

	//create a global JButton object
	private static JButton closeWindowButton = new JButton("Close Printer Window");
	private static JButton printButton = new JButton("Print The Receipt");
	//create the printer frame
    private static JFrame printerFrame = new JFrame("Den-Art Printer");
	
	/**
	 * Print method handles the printing of receipts (graphics, the format
	 * of printed pages, and the number of pages).
	 * @throws Printer Exception is thrown
	 * @return PAGE_EXISTS - the page is part of the printed document
	 */
    public int print(Graphics graphics, PageFormat pageFormat, int page) throws PrinterException {

		//there is only one page to print
        if (page > 0) {
            return NO_SUCH_PAGE;
        }

        //user (0,0) is typically outside the imageable area, so we must
        //translate by the X and Y values in the PageFormat to avoid clipping
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        //perform the rendering
        //g.drawString("DenArtPrintCopyright!", 100, 100);

        return PAGE_EXISTS;
    }

	@Override
    public void actionPerformed(ActionEvent e) {

		//main print window pops up when the print button is clicked
		if (e.getSource() == printButton) {
			//set the printer dialog box and get document ready to print
	        PrinterJob job = PrinterJob.getPrinterJob();
	        job.setPrintable(this);
	        boolean ok = job.printDialog();
	
				 if (ok) {
					 try {
						  job.print();
					 }
					 catch (PrinterException ex) {
					 	System.out.println("Something went wrong!");
					 }
				 }
		} 
		
		//print window is closed when close window button is clicked
		if (e.getSource() == closeWindowButton) {
			 printerFrame.setVisible(false);
		}
    }

	/**
	 * This method styles the buttons of the
	 * printer window.
	 */
	public static void styleButtons() {
		
		//style the buttons
		printButton.setForeground(Color.BLUE);
		printButton.setOpaque(true);
		printButton.setBackground(Color.YELLOW);
		closeWindowButton.setForeground(Color.BLUE);
		closeWindowButton.setOpaque(true);
		closeWindowButton.setBackground(Color.YELLOW);
	}
	
	/**
	 * Constructor used to add action listener to
	 * the close windows button.
	 */
	public DenArtPrinter() {
		
		//add action listener to the close button
		closeWindowButton.addActionListener(this);
	}
	
	/**
	 * The method builds the frame and launch the application
	 * @param args an array of command-line arguments
	 * passed to this method
	 */
    public static void main(String args[]) {

    	styleButtons();
    	
		//set the Look&Feel of the printer frame
        UIManager.put("swing.boldMetal", Boolean.FALSE);

		//add a window listener to the printer frame
		//close the printer frame when the printer job has completed
		printerFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {System.exit(0);}
	    });
		
		//add action listener to the printer button		
		printButton.addActionListener(new DenArtPrinter());

		//set the fetures of the frame
		printerFrame.add(printButton, "North");
		printerFrame.add(closeWindowButton, "South");
		printerFrame.setSize(240,95);
		printerFrame.setLocation(5, 5);
		printerFrame.setResizable(false);
		printerFrame.setVisible(true);
	}
}