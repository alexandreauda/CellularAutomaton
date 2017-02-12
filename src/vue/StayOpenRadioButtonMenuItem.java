package vue;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// TODO: Auto-generated Javadoc
/**
 * An extension of JRadioButtonMenuItem that doesn't close the menu when selected.
 *
 */
public class StayOpenRadioButtonMenuItem extends JRadioButtonMenuItem {

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
	 * Instantiates a new stay open radio button menu item.
	 *
	 * @see JRadioButtonMenuItem#JRadioButtonMenuItem()
	 */
	public StayOpenRadioButtonMenuItem() {
		super();
	}

	/**
	 * Instantiates a new stay open radio button menu item.
	 *
	 * @param a the a
	 * @see JRadioButtonMenuItem#JRadioButtonMenuItem(Action)
	 */
	public StayOpenRadioButtonMenuItem(Action a) {
		super();
	}

	/**
	 * Instantiates a new stay open radio button menu item.
	 *
	 * @param icon the icon
	 * @see JRadioButtonMenuItem#JRadioButtonMenuItem(Icon)
	 */
	public StayOpenRadioButtonMenuItem(Icon icon) {
		super(icon);
	}

	/**
	 * Instantiates a new stay open radio button menu item.
	 *
	 * @param icon the icon
	 * @param selected the selected
	 * @see JRadioButtonMenuItem#JRadioButtonMenuItem(Icon, boolean)
	 */
	public StayOpenRadioButtonMenuItem(Icon icon, boolean selected) {
		super(icon, selected);
	}

	/**
	 * Instantiates a new stay open radio button menu item.
	 *
	 * @param text the text
	 * @see JRadioButtonMenuItem#JRadioButtonMenuItem(String)
	 */
	public StayOpenRadioButtonMenuItem(String text) {
		super(text);
	}

	/**
	 * Instantiates a new stay open radio button menu item.
	 *
	 * @param text the text
	 * @param selected the selected
	 * @see JRadioButtonMenuItem#JRadioButtonMenuItem(String, boolean)
	 */
	public StayOpenRadioButtonMenuItem(String text, boolean selected) {
		super(text, selected);
	}

	/**
	 * Instantiates a new stay open radio button menu item.
	 *
	 * @param text the text
	 * @param icon the icon
	 * @see JRadioButtonMenuItem#JRadioButtonMenuItem(String, Icon)
	 */
	public StayOpenRadioButtonMenuItem(String text, Icon icon) {
		super(text, icon);
	}

	/**
	 * Instantiates a new stay open radio button menu item.
	 *
	 * @param text the text
	 * @param icon the icon
	 * @param selected the selected
	 * @see JRadioButtonMenuItem#JRadioButtonMenuItem(String, Icon, boolean)
	 */
	public StayOpenRadioButtonMenuItem(String text, Icon icon, boolean selected) {
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