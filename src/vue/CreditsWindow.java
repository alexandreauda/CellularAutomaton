package vue;

import java.awt.Color;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;



// TODO: Auto-generated Javadoc
/**
 * The Class MainWindow.
 */
public class CreditsWindow extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** ****ATTRIBUTES*****. */

	/** The pan JPanel to put our components. */
	private JPanel pan = new JPanel();

	/** Création du JTextPane. */
	private static JTextPane m_JtextPane = new JTextPane();


	/**
	 * ****CONSTRUCTOR*****.
	 *
	 * @param title the title
	 * @param contributorList the contributor list
	 */
	public CreditsWindow (String title, StringBuilder contributorList){

		//Set the window
		this.setWindow();

		//add the JPanel pan to the window
		this.getContentPane().add(pan);
		
		//add the list of contributors in the window
		displayListContributors(title, contributorList.toString()); //display the list of contributors with all the styles
		m_JtextPane.setEditable(false);//Set the JTextPane non editable
		m_JtextPane.setOpaque(false);//Set the JTextPane non opaque
		m_JtextPane.setCaretPosition(0); //Set the scroll in he top of the window

		//add the JtextPane to the window
		this.add(m_JtextPane); 
		
		//add the scroll to the JtextPane
		this.add(new JScrollPane(m_JtextPane)); 
		
		//Set the window visible
		this.setVisible(true);
	}



	/**
	 * ****CLASS METHODS*****.
	 */

	/***Set the window***/
	private void setWindow(){
		this.setWindow("Credits", 350, 450, false, false);
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

	/**
	 * Display list of contributors and set all the style for the list.
	 *
	 * @param titre the title
	 * @param listContributors the list contributors
	 */
	public static void displayListContributors(String titre, String listContributors){

		/*
		 * Création d'un style
		 * (le style du texte de la liste des contributeurs)
		 */
		SimpleAttributeSet style_normal = new SimpleAttributeSet();
		StyleConstants.setFontFamily(style_normal, "Calibri"); //definit la police 
		StyleConstants.setFontSize(style_normal, 20); //definit la taille

		/*
		 * Création du style pour l'affichage du titre
		 */
		SimpleAttributeSet style_titre = new SimpleAttributeSet();
		style_titre.addAttributes(style_normal);
		StyleConstants.setForeground(style_titre, Color.BLUE); //definit la couleur du titre
		StyleConstants.setUnderline(style_titre, true); //Souligne le titre
		StyleConstants.setFontSize(style_titre, 36); //definit la taille du titre
		StyleConstants.setBold(style_titre, true); //Met le titre en gras

		/*
		 * Création du style qui permet de centrer le texte
		 */
		SimpleAttributeSet centrer = new SimpleAttributeSet();
		StyleConstants.setAlignment(centrer, StyleConstants.ALIGN_CENTER); //centre le texte


		try {
			/*
			 * Récupération du style du document 
			 */
			StyledDocument doc = m_JtextPane.getStyledDocument();

			/*
			 * Insertion d'une chaine de caractères dans le document
			 * insertString :
			 * 	position de départ dans le document (doc.getLength ajoute à la fin
			 *  texte à ajouter
			 *  style pour le texte à ajouter
			 */
			doc.insertString(doc.getLength(), titre+"\n\n", style_titre);
			doc.insertString(doc.getLength(), listContributors+"\n", style_normal);
			int end_list=doc.getLength();

			/*
			 * Centrage du titre
			 */
			doc.setParagraphAttributes(0, end_list, centrer, false);
			

		}
		catch (BadLocationException e) {
			e.printStackTrace();
		}


	}



}
