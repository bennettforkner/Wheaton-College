package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * numListener
 *
 * Class to add a digit to the internal state
 *
 * @author Bennett Forkner
 * CS 245, Wheaton College
 * December 6, 2018
 */
public class numListener implements ActionListener {
	/**
	 * the integer that holds the single-digit number value that the listener responds to 
	 */
	private int num;
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
	public numListener(int num, InternalState state) {
		this.state = state;
		this.num = num;
	}
	
	/**
	 * Method to act and call the InternalState method respective to the button pushed
	 */
	public void actionPerformed(ActionEvent e) {
		state.addDigit(num);
	}

}
