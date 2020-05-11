package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * NumListener
 * 
 * Class to be activated when a number button on the calculator is pressed
 * 
 * @author Bennett Forkner
 * CS 245, Wheaton College
 * November 18, 2018
 */
public class NumListener implements ActionListener {
	/**
	 * the integer that holds the single-digit number value that the listener responds to 
	 */
	private int val;
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
	public NumListener(int val, InternalState state) {
		this.val = val;
		this.state = state;
	}
	
	/**
	 * Method to act and call the InternalState method respective to the button pushed
	 */
	public void actionPerformed(ActionEvent e) {
		state.addToState(val);
		
	}

}
