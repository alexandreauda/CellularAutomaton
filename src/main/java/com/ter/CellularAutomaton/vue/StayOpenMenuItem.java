package com.ter.CellularAutomaton.vue;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// TODO: Auto-generated Javadoc
/**
 * An extension of JMenuItem that doesn't close the menu when selected.
 *
 */
public class StayOpenMenuItem extends JMenuItem {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The path. */
	private static MenuElement[] path;

	{
		getModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (getModel().isArmed() && isShowing()) {
					path = MenuSelectionManager.defaultManager().getSelectedPath();
				}
			}
		});
	}

	/**
	 * Instantiates a new stay open menu item.
	 *
	 * @see JMenuItem#JMenuItem()
	 */
	public StayOpenMenuItem() {
		super();
	}

	/**
	 * Instantiates a new stay open menu item.
	 *
	 * @param a the a
	 * @see JMenuItem#JMenuItem(javax.swing.Action)
	 */
	public StayOpenMenuItem(Action a) {
		super(a);
	}

	/**
	 * Instantiates a new stay open menu item.
	 *
	 * @param icon the icon
	 * @see JMenuItem#JMenuItem(javax.swing.Icon)
	 */
	public StayOpenMenuItem(Icon icon) {
		super(icon);
	}

	/**
	 * Instantiates a new stay open menu item.
	 *
	 * @param text the text
	 * @see JMenuItem#JMenuItem(java.lang.String)
	 */
	public StayOpenMenuItem(String text) {
		super(text);
	}

	/**
	 * Instantiates a new stay open menu item.
	 *
	 * @param text the text
	 * @param icon the icon
	 * @see JMenuItem#JMenuItem(java.lang.String, javax.swing.Icon)
	 */
	public StayOpenMenuItem(String text, Icon icon) {
		super(text, icon);
	}

	/**
	 * Instantiates a new stay open menu item.
	 *
	 * @param text the text
	 * @param mnemonic the mnemonic
	 * @see JMenuItem#JMenuItem(java.lang.String, int)
	 */
	public StayOpenMenuItem(String text, int mnemonic) {
		super(text, mnemonic);
	}

	/**
	 * Overridden to reopen the menu.
	 *
	 * @param pressTime the time to "hold down" the button, in milliseconds
	 */
	@Override
	public void doClick(int pressTime) {
		super.doClick(pressTime);
		MenuSelectionManager.defaultManager().setSelectedPath(path);
	}
}