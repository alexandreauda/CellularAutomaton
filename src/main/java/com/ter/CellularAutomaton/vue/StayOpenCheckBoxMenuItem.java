package com.ter.CellularAutomaton.vue;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


// TODO: Auto-generated Javadoc
/**
 * An extension of JCheckBoxMenuItem that doesn't close the menu when selected.
 *
 */
public class StayOpenCheckBoxMenuItem extends JCheckBoxMenuItem {

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
	 * Instantiates a new stay open check box menu item.
	 *
	 * @see JCheckBoxMenuItem#JCheckBoxMenuItem()
	 */
	public StayOpenCheckBoxMenuItem() {
		super();
	}

	/**
	 * Instantiates a new stay open check box menu item.
	 *
	 * @param a the a
	 * @see JCheckBoxMenuItem#JCheckBoxMenuItem(Action)
	 */
	public StayOpenCheckBoxMenuItem(Action a) {
		super(a);
	}

	/**
	 * Instantiates a new stay open check box menu item.
	 *
	 * @param icon the icon
	 * @see JCheckBoxMenuItem#JCheckBoxMenuItem(Icon)
	 */
	public StayOpenCheckBoxMenuItem(Icon icon) {
		super(icon);
	}

	/**
	 * Instantiates a new stay open check box menu item.
	 *
	 * @param text the text
	 * @see JCheckBoxMenuItem#JCheckBoxMenuItem(String)
	 */
	public StayOpenCheckBoxMenuItem(String text) {
		super(text);
	}

	/**
	 * Instantiates a new stay open check box menu item.
	 *
	 * @param text the text
	 * @param selected the selected
	 * @see JCheckBoxMenuItem#JCheckBoxMenuItem(String, boolean)
	 */
	public StayOpenCheckBoxMenuItem(String text, boolean selected) {
		super(text, selected);
	}

	/**
	 * Instantiates a new stay open check box menu item.
	 *
	 * @param text the text
	 * @param icon the icon
	 * @see JCheckBoxMenuItem#JCheckBoxMenuItem(String, Icon)
	 */
	public StayOpenCheckBoxMenuItem(String text, Icon icon) {
		super(text, icon);
	}

	/**
	 * Instantiates a new stay open check box menu item.
	 *
	 * @param text the text
	 * @param icon the icon
	 * @param selected the selected
	 * @see JCheckBoxMenuItem#JCheckBoxMenuItem(String, Icon, boolean)
	 */
	public StayOpenCheckBoxMenuItem(String text, Icon icon, boolean selected) {
		super(text, icon, selected);
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