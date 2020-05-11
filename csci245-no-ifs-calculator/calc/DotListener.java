package calc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * DotListener
 *
 * Class to call the InternalState method for adding a dot based on input from the GUI
 *
 * @author Bennett Forkner
 * CS 245, Wheaton College
 * December 6, 2018
 */
public class DotListener implements ActionListener {
	/**
	 * the InternalState object that will be used to call the methods
	 */
	private InternalState state;
	
	/**
	 * Constructor of the listener
	 * 
	 * @param state the InternalState object that will be used to call the methods
	 */
	public DotListener(InternalState state) {
		this.state = state;
	}
	
	/**
	 * Method to act and call the InternalState method respective to the button pushed
	 */
	public void actionPerformed(ActionEvent e) {
		state.addDecimal();
	}
}
