package com.ter.CellularAutomaton.controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import com.ter.CellularAutomaton.vue.ElementaryRulesWindow;

// TODO: Auto-generated Javadoc
/**
 * The Class PasteElementaryRulesWindowEvent. This class is used to paste the text present in the clipboard within text fields.
 */
public class PasteElementaryRulesWindowEvent implements ActionListener {

	/** ****ATTRIBUTES*****. */
	private ElementaryRulesWindow m_window;


	/**
	 * ****CONSTRUCTOR*****.
	 *
	 * @param window the window
	 */
	public PasteElementaryRulesWindowEvent(ElementaryRulesWindow window) {
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
		System.out.println("Clipboard contains:" + this.getClipboardContents());
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
		if(m_window.getm_isRadiusFocus()){
			m_window.getm_formattedTextFieldRadius().replaceSelection("");
			int positionCursor = m_window.getm_formattedTextFieldRadius().getCaretPosition();
			String oldText = m_window.getm_formattedTextFieldRadius().getText();
			m_window.getm_formattedTextFieldRadius().setText(oldText.substring(0, positionCursor) + this.getClipboardContents() + oldText.substring(positionCursor, oldText.length()));
			//m_window.getm_formattedTextFieldRadius().insert(this.getClipboardContents(), m_window.getm_formattedTextFieldRadius().getCaretPosition());
			//printClipboard();
		}
		else{
			m_window.getm_formattedTextFieldRules().replaceSelection("");
			int positionCursor1 = m_window.getm_formattedTextFieldRules().getCaretPosition();
			String oldText1 = m_window.getm_formattedTextFieldRules().getText();
			m_window.getm_formattedTextFieldRules().setText(oldText1.substring(0, positionCursor1) + this.getClipboardContents() + oldText1.substring(positionCursor1, oldText1.length()));
			//m_window.getm_formattedTextFieldRadius().insert(this.getClipboardContents(), m_window.getm_formattedTextFieldRadius().getCaretPosition());
			//printClipboard();
		}


		/***SECOND METHOD***/
		//		Robot robot = null;
		//		try {
		//			robot = new Robot(); /** création du robot */ 
		//		} catch (AWTException e1) {
		//			e1.printStackTrace();
		//		}	
		//		try{
		//		robot.keyPress(KeyEvent.CTRL_DOWN_MASK+ KeyEvent.VK_V);
		//		printClipboard();
		//		}
		//		catch (NullPointerException e2){
		//			e2.printStackTrace();
		//		}




	}


}
