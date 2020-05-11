package calc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ClearListener
 *
 * Class to call the InternalState method for clearing the face based on input from the GUI
 *
 * @author Bennett Forkner
 * CS 245, Wheaton College
 * December 6, 2018
 */

public class ClearListener implements ActionListener {
	/**
	 * the InternalState object that will be used to call the methods
	 */
	private InternalState state;

	/**
	 * Constructive of the listener
	 * 
	 * @param state the InternalState object that will be used to call the methods
	 * @param face the CalculatorFace object that will be used to call the methods
	 */
	public ClearListener(InternalState state) {
		this.state = state;
	}
	
	/**
	 * Method to act and call the InternalState method respective to the button pushed
	 */
	public void actionPerformed(ActionEvent e) {
		state.clearFace();
	}
}
