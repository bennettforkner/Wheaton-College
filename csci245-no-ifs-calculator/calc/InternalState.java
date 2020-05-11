package calc;


/**
 * InternalState
 *
 * Class to represent the values saved in the calculator and send them to the GUI interface
 *
 * @author Bennett Forkner
 * CS 245, Wheaton College
 * December 6, 2018
 */

public class InternalState {
	
	public static InternalState INSTANCE;
	
	/**
	 * A Calculator face (passed in the constructor) that allows the GUI to be updated
	 */
	private CalculatorFace face;
	
	/**
	 * The current index in 'nums' that is being focused on at the moment
	 */
	private int currentNum;
	
	/**
	 * The two numbers being stored in the state
	 */
	private String[] nums;
	
	/**
	 * The current operator of the function
	 */
	private OperatorListener currentOperator;
	
	
	/**
	 * Constructor to make a new calculator state
	 * 
	 * @param face the calculator face from which the values will be received and to which the updated values will be sent
	 */
	public InternalState(CalculatorFace face) {
		INSTANCE = this;
		currentNum = 0;
		nums = new String[2];
		nums[0] = nums[1] = "";
		currentOperator = OperatorListener.INSTANCE; // this acts similarly to being null but is still able to move to the next OperatorListener
		this.face = face;
		face.writeToScreen("Hello     World");
	}
	
	/**
	 * Method to add a digit to the current number
	 * @param d the digit to be added
	 */
	public void addDigit(int d) {
		nums[currentNum] += d;
		printToScreen(nums[currentNum]);
	}
	
	/**
	 * Method to add a '.' to the current number
	 */
	public void addDecimal() {
		nums[currentNum] += ".";
		printToScreen(nums[currentNum]);
	}

	/**
	 * @return the num1
	 */
	public String getNum() {
		return nums[currentNum];
	}

	/**
	 * @param num1 the num1 to set
	 */
	public void setNum(String num1) {
		this.nums[currentNum] = num1;
	}


	
	/**
	 * Method to display a String on the screen
	 * @param toPrint the String to display
	 * @return 
	 */
	public String printToScreen(String toPrint) {
		face.writeToScreen(toPrint);
		return toPrint;
	}
	
	/**
	 * Method to print the current number to the calculator face
	 */
	public void printCurrentNum() {
		String toPrint = nums[currentNum];
		face.writeToScreen(nums[currentNum]);
	}

	/**
	 * Method to check if the operator can be changed
	 * @param OP the OperatorListener to be updated
	 */
	public void setOperator(OperatorListener OP) {
		currentOperator.tryMoveToNext(OP);
	}
	
	/**
	 * Method to change the actual operator
	 * @param OP the OperatorListener to be updated
	 */
	public void setOperatorConfirmed(OperatorListener OP) {
		this.currentOperator = OP;
	}
	
	/**
	 * Method to access the current OperatorListener
	 * @return the current OperatorListener
	 */
	public OperatorListener getOperator() {
		return currentOperator;
	}
	
	/**
	 * Method to clear the calculator face and set everything back to origin values
	 */
	public void clearFace() {
		currentNum = 0;
		nums[0] = "";
		nums[1] = "";
		currentOperator = OperatorListener.INSTANCE;
		printToScreen("");
	}

	/**
	 * @return the currentNum
	 */
	public int getCurrentNum() {
		return currentNum;
	}

	/**
	 * @param currentNum the currentNum to set
	 */
	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}
	
}
