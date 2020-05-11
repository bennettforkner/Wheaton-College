package calc;

import java.util.Stack;

/**
 * InternalState
 *
 * Class to represent the values saved in the calculator and send them to the GUI interface
 *
 * @author Bennett Forkner
 * CS 245, Wheaton College
 * September 27, 2018
 */

public class InternalState {
	
	/**
	 * The value of the stored numbers and operands in the program
	 */
	private String state;
	
	private Stack<Integer> numStack;
	
	/**
	 * A Calculator face (passed in the constructor) that allows the GUI to be updated
	 */
	private CalculatorFace face;
	
	
	private boolean lastWasInt = false;
	
	/**
	 * Constructor to make a new calculator state
	 * 
	 * @param face the calculator face from which the values will be received and to which the updated values will be sent
	 */
	public InternalState(CalculatorFace face) {
		numStack = new Stack<Integer>();
		state = "";
		this.face = face;
		face.writeToScreen("Hello     World");
	}
	
	/**
	 * A method to add a char to the state String
	 */
	public void addToState(char s) {
		
		if (s == '.') {
			face.writeToScreen(state + '.');
		} else {
			if (numStack.size() < 2) {
				face.writeToScreen(state);
				return;
			}
			state = "";
			int num2 = numStack.pop();
			int num1 = numStack.pop();
			if (s == '+') {
				numStack.push(num1 + num2);
			} else if (s == '-') {
				numStack.push(num1 - num2);
			} else if (s == '*') {
				numStack.push(num1 * num2);
			} else if (s == '/') {
				numStack.push(num1 / num2);
			}
			
			face.writeToScreen("" + numStack.peek());
		}
		state += s;
		lastWasInt = false;
	}
	
	/**
	 * A method to add an int to the state String
	 */
	public void addToState(int s) {
		state += s;
		if (!lastWasInt)
			numStack.push(s);
		else {
			int getNum = numStack.pop();
			getNum *= 10;
			getNum += s;
			numStack.push(getNum);
		}
		lastWasInt = true;
		face.writeToScreen("" + state);
	}
	
	/**
	 * A method to receive the state
	 * @return stateInt
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * A method to write the stateInt to the screen with a the correct amount of decimal spaces
	 */
	public void printIt() {
		face.writeToScreen(state);
	}
	
	
	
	
	/**
	 * A method to clear all of the values of the variables and clear the calculator face
	 */
	public void clearFace() {
		state = "";
		lastWasInt = false;
		numStack.clear();
		face.writeToScreen("");
	}

	
}
