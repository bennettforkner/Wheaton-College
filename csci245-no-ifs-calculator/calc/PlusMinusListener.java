package calc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * PlusMinusListener
 *
 * Class to set the number to negative
 *
 * @author Bennett Forkner
 * CS 245, Wheaton College
 * December 6, 2018
 */

public class PlusMinusListener implements ActionListener {
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
	public PlusMinusListener(InternalState state) {
		this.state = state;
	}
	
	/**
	 * Method to act and call the InternalState method respective to the button pushed
	 */
	public void actionPerformed(ActionEvent e) {
		state.setNum("-" + state.getNum());
		state.printCurrentNum();
	}
}