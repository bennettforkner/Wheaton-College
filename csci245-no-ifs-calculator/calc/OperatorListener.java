package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * OperatorListener
 *
 * Class to allow methods for calculating values (in an operator)
 *
 * @author Bennett Forkner
 * CS 245, Wheaton College
 * December 6, 2018
 */

public class OperatorListener {
	private InternalState state;
	/**
	 * An instance of this class that acts like a null operator when referenced in InternalState
	 */
	public static OperatorListener INSTANCE = new OperatorListener(InternalState.INSTANCE);
	/**
	 * A constructor that is not able to be called except for locally
	 */
	private OperatorListener() {}
	
	/**
	 * A constructor that is called by the subclasses in using super
	 * @param s
	 */
	protected OperatorListener(InternalState s) {
		this.state = s;
	}
	
	/**
	 * The method to calculate the value based on the identity of the operator
	 * @return empty string because this class acts similarly to a null object
	 */
	public String calculate() {
		return "";
	}
	
	/**
	 * Method to move to the next operator
	 * @param e the operator to move to next
	 */
	public void tryMoveToNext(OperatorListener e) {
		state.setOperatorConfirmed(e);
	}
	
	/**
	 * Method to calculate the new value based on this type of operator when the '=' button is pressed
	 */
	public String calculateFinal() {
		return "";
	}
	
}
