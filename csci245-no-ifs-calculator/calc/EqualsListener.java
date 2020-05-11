package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * EqualsListener
 *
 * Class to call the InternalState methods for calculating based on input from the GUI
 *
 * @author Bennett Forkner
 * CS 245, Wheaton College
 * December 6, 2018
 */

public class EqualsListener implements ActionListener {
	/**
	 * the InternalState object that will be used to call the methods
	 */
	private InternalState state;
	
	/**
	 * Constructor of the listener
	 * 
	 * @param state the InternalState object that will be used to call the methods
	 * @param face the CalculatorFace object that will be used to call the methods
	 */
	public EqualsListener(InternalState state) {
		this.state = state;
	}

	/**
	 * Method to act and call the InternalState method respective to the button pushed
	 */
	public void actionPerformed(ActionEvent e) {
		state.setCurrentNum(0);
		state.setNum(state.getOperator().calculateFinal());
		state.setCurrentNum(1);
		state.setNum("");
		state.setOperatorConfirmed(OperatorListener.INSTANCE);
		
	}

}
