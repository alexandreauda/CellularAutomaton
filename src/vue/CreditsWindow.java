package vue;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.Border;



// TODO: Auto-generated Javadoc
/**
 * The Class MainWindow.
 */
public class CreditsWindow extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/******ATTRIBUTES******/
	/** The question JLabel. */
	protected JLabel titleLabel;

	/** The text pane to display the result (film name and summary). */
	protected JTextArea textPane = new JTextArea("Hello Master!", 21, 33);
 
	/** The pan JPanel to put our components. */
	//On create a JPanel
	private JPanel pan = new JPanel();
	
	/** The window width. */
	protected int window_width; //width of the window

	/** The window height. */
	protected int window_height; //height of the window


	
	/**
	 * ****CONSTRUCTOR*****.
	 */
	public CreditsWindow (String title, StringBuilder contributorList){

		/***Set the window***/
		this.setWindow();
		
		window_width=this.getWidth(); //initialize the attribute window_width with the width of the window
		window_height=this.getHeight(); //initialize the attribute window_height with the height of the window


		//add the JPanel pan to the window
				this.getContentPane().add(pan);
				pan.setBounds(window_width,window_height, 150, 150); //Set the dimension of the JPanel
				titleLabel = new JLabel(title);
				//Creating a Container with Horizontal Management
				Box b0 = Box.createHorizontalBox();
				b0.add(titleLabel); //add the JLabel which will contain the question ask to the user in the JPanel
				Box b1 = Box.createHorizontalBox();
				b1.add(textPane); //add the JLabel which will contain the question ask to the user in the JPanel
				
				//Creating a Container with Vertical Management
				Box b2 = Box.createVerticalBox();
				b2.add(b0);
				b2.add(b1);
				
				pan.add(b2);
				
				textPane.setLineWrap(true); //Sets the line-wrapping policy of the text area. If set to true the lines will be wrapped if they are too long to fit within the allocated width.
				textPane.setText(contributorList.toString());//Set the text of the textPane with the comments of the film
				textPane.setEditable(false);
				textPane.setOpaque(false);
				textPane.setBorder(null);
				textPane.setCaretPosition(0);
				this.add(new JScrollPane(pan)); //add the scroll

		//Set the window visible
		this.setVisible(true);
	}



	/**
	 * ****CLASS METHODS*****.
	 */

	/***Set the window***/
	private void setWindow(){
		this.setWindow("Credits", 500, 400, false, false);
	}


	/**
	 * *Set the window**.
	 *
	 * @param title the title
	 * @param width the width
	 * @param height the height
	 * @param isResisable the is resisable
	 * @param isAlwayOnTop the is alway on top
	 */
	private void setWindow(String title, int width, int height, boolean isResisable, boolean isAlwayOnTop){
		this.setTitle(title);//Define a title to the window    
		this.setSize(width,height);//Initial size of the window
		this.setLocationRelativeTo(null);//We now ask our window to position itself at the center.
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Complete the process when clicking on the red cross
		this.setResizable(isResisable);//Prevents resizing
		this.setAlwaysOnTop(isAlwayOnTop);//The windows will not be always on top

	}

	
}
