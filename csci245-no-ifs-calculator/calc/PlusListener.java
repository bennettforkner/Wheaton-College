package calc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * PlusListener
 *
 * Class to calculate the number by addition
 *
 * @author Bennett Forkner
 * CS 245, Wheaton College
 * December 6, 2018
 */

public class PlusListener extends OperatorListener implements ActionListener {
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
	public PlusListener(InternalState state) {
		super(state);
		this.state = state;
	}
	
	/**
	 * Method to act and call the InternalState method respective to the button pushed
	 */
	public void actionPerformed(ActionEvent e) {
		state.setOperator(this);
		state.setCurrentNum(1);
	}
	
	/**
	 * Method to calculate the new value based on this type of operator
	 */
	@Override
	public String calculate() {
		state.setCurrentNum(0);
		double num1 = Double.parseDouble(state.getNum());
		state.setCurrentNum(1);
		double num2 = Double.parseDouble(state.getNum());
		String s = state.printToScreen("" + (num1 + num2));
		state.setCurrentNum(0);
		state.setNum("" + (num1 + num2));
		state.setCurrentNum(1);
		state.setNum("");
		return s;
	}
	
	/**
	 * Method to calculate the new value based on this type of operator when the '=' button is pressed
	 */
	public String calculateFinal() {
		state.setCurrentNum(0);
		double num1 = Double.parseDouble(state.getNum());
		state.setCurrentNum(1);
		double num2 = Double.parseDouble(state.getNum());
		state.setCurrentNum(0);
		return state.printToScreen("" + (num1 + num2));
	}
	
	/**
	 * Method to test if the move is possible to the next operator if not, it calculates first
	 * @param e the operator to move to next
	 */
	public void tryMoveToNext(OperatorListener e) {
		state.getOperator().calculate();
		state.setOperatorConfirmed(e);
	}
}
