package com.ter.CellularAutomaton.controller;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.ter.CellularAutomaton.vue.LocalElementaryRulesWindow;

/**
 * The Class CopyElementaryRulesWindowEvent. This class is used to cut some selected text from a text field within the clipboard.
 */
public class CutLocalElementaryRulesWindow implements ActionListener {

	/** ****ATTRIBUTES*****. */
	private LocalElementaryRulesWindow m_window;


	/**
	 * ****CONSTRUCTOR*****.
	 *
	 * @param window the window
	 */
	public CutLocalElementaryRulesWindow(LocalElementaryRulesWindow window) {
		super();
		this.m_window = window;

	}


	/**
	 * ****CLASS METHODS*****.
	 *
	 * @return the string
	 */

	private String printClipboard (){
		//display what is currently on the clipboard
		System.out.println("Clipboard contains: " + this.getClipboardContents());
		return "Clipboard contains: " + this.getClipboardContents();
	}

	/**
	 * Get the String residing on the clipboard.
	 *
	 * @return any text found on the Clipboard; if none found, return an
	 * empty String.
	 */
	private String getClipboardContents() {
		String result = "";
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		//odd: the Object param of getContents is not currently used
		Transferable contents = clipboard.getContents(null);
		boolean hasTransferableText =
				(contents != null) &&
				contents.isDataFlavorSupported(DataFlavor.stringFlavor)
				;
		if (hasTransferableText) {
			try {
				result = (String)contents.getTransferData(DataFlavor.stringFlavor);
			}
			catch (UnsupportedFlavorException | IOException ex){
				System.out.println(ex);
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * Place a String on the clipboard, and make this class the
	 * owner of the Clipboard's contents.
	 *
	 * @param aString the new clipboard contents
	 */
	public void setClipboardContents(String aString){
		StringSelection stringSelection = new StringSelection(aString);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/***FIRST METHOD***/
		if(m_window.getm_isComponentFocus()[0]){
			String selectedText = m_window.getm_formattedTextFieldX1().getSelectedText(); // Get selected text.
			setClipboardContents(selectedText); // Put selected text in the clipboard.
			m_window.getm_formattedTextFieldX1().replaceSelection(""); // Cut the selected text.
			//printClipboard(); // Print the content of the clipboard.
		}
		else if(m_window.getm_isComponentFocus()[1]){
			String selectedText = m_window.getm_formattedTextFieldX2().getSelectedText(); // Get selected text.
			setClipboardContents(selectedText); // Put selected text in the clipboard.
			m_window.getm_formattedTextFieldX2().replaceSelection(""); // Cut the selected text.
			//printClipboard(); // Print the content of the clipboard.
		}
		else if(m_window.getm_isComponentFocus()[2]){
			String selectedText = m_window.getm_formattedTextFieldRadius().getSelectedText(); // Get selected text.
			setClipboardContents(selectedText); // Put selected text in the clipboard.
			m_window.getm_formattedTextFieldRadius().replaceSelection(""); // Cut the selected text.
			//printClipboard(); // Print the content of the clipboard.
		}
		else{
			String selectedText1 = m_window.getm_formattedTextFieldRules().getSelectedText(); // Get selected text.
			setClipboardContents(selectedText1); // Put selected text in the clipboard.
			m_window.getm_formattedTextFieldRules().replaceSelection(""); // Cut the selected text.
			//printClipboard(); // Print the content of the clipboard.
		}

	
		/***SECOND METHOD***/
		//		Robot robot = null;
		//		try {
		//			robot = new Robot(); /** création du robot */ 
		//		} catch (AWTException e1) {
		//			e1.printStackTrace();
		//		}	
		//		try{
		//		robot.keyPress(KeyEvent.CTRL_MASK + KeyEvent.VK_V);
		//		printClipboard();
		//		}
		//		catch (NullPointerException e2){
		//			e2.printStackTrace();
		//		}

	}


}
