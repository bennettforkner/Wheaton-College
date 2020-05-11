
package calc;

import java.awt.event.ActionListener;

/**
 * SetUp
 * 
 * Class to set up and start the calculator, plus
 * facilities for test-driving the calculator.
 *
 * @author Thomas VanDrunen (revised by Bennett Forkner, 2018)
 * CS 245, Wheaton College
 * June 27, 2014
*/
public class SetUp {

	/**
	 * Method for initializing the calculator internals and
	 * connecting them to the calculator face.
	 * @param face The component representing the user interface of 
	 * the calculator. 
	 */
	public static void setUpCalculator(CalculatorFace face) {
		//Add all the buttons to the CalculatorFace
		InternalState state = new InternalState(face);
		face.addActionListener('+', new CalcListener('+',state));
		face.addActionListener('-', new CalcListener('-',state));
		face.addActionListener('*', new CalcListener('*',state));
		face.addActionListener('/', new CalcListener('/',state));
		face.addActionListener('C', new ClearListener(state));
		face.addActionListener('.', new CalcListener('.',state));
		
		face.addNumberActionListener(0, new NumListener(0, state));
		face.addNumberActionListener(1, new NumListener(1, state));
		face.addNumberActionListener(2, new NumListener(2, state));
		face.addNumberActionListener(3, new NumListener(3, state));
		face.addNumberActionListener(4, new NumListener(4, state));
		face.addNumberActionListener(5, new NumListener(5, state));
		face.addNumberActionListener(6, new NumListener(6, state));
		face.addNumberActionListener(7, new NumListener(7, state));
		face.addNumberActionListener(8, new NumListener(8, state));
		face.addNumberActionListener(9, new NumListener(9, state));
	}
	
	
	/**
	 * This main method is for your testing of your calculator.
	 * It will *not* be used during grading. Any changes you make
	 * to this method will be ignored at grading.
	 */
	public static void main(String[] args) {
		setUpCalculator(new PlainCalculatorFace());
	}

}
