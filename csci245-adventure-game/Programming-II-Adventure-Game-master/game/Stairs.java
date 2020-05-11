package game;

/**
 * A class to represent stairs.
 * It is represented as an Item and it extends the Item abstract class.
 * @author AllPassesTests Team
 * CS 245, Fall 2018
 * Project 4, Adventure Game
 *
 */
public class Stairs extends Item {
	
	/**
	 * An integer to keep track of how many stairs have been made. 
	 * It is static because the value for count shouldn't change depending on the instance
	 */
	private static int count = 0;
	
	/**
	 * A variable to represent the current stair number that the instance is.
	 */
	private int number;
	
	/**
	 * The requirement needed to use the stairs.
	 */
	private String requirement;
	
//	****************************************************************************************************
	
	/**
	 * Constructor for stairs.
	 * Every time a item stairs is created, it will increment the total count.
	 * Certain stair wells can only be used with a requirement. 
	 * @param requirement
	 */
	public Stairs(String requirement) {
		super(Stairs.class.getSimpleName());
		this.requirement = requirement;
		count++;
		number = count;
	}
	
//  ****************************************************************************************************
	
	/**
	 * A method to get the name of the Stairs.
	 * @return name The name of the stairs and which number it is.
	 */
	public String getName() {
		return "Stairwell #" + number + " (out of " + count + " total stair wells).";
	}

	/**
	 * A method to see if there is a requirement in order to use the stairs.
	 * @return whether or not a requirement exists.
	 */
	public boolean hasRequirement() {
		return (requirement != null);	//if a requirement exits than return true if it deosn't return false
	}

	/**
	 * A method to reveal the requirement needed to pick up the stairs.
	 * @return requirement The name of the required item that is needed to use the stairs else return nothing.
	 */
	public String revealRequirement() {
		if(this.hasRequirement()) {
			return requirement;
		} else {
			return "";
		}
	}
	
	/**
	 * @return The stairs item?
	 */
	public Item getItem() {
		return this;
	}

}
