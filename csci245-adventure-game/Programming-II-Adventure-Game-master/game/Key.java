package game;

/**
 * Key.java
 * 
 * Class to model a key that can be used to unlock chests
 *
 * @author AllPassesTests Team
 * Wheaton College, CS 245, Fall 2018
 * Project 4, Adventure Game
 *
 */

public class Key extends Item {
	
	/**
	 * A static variable to store the total amount of keys made
	 */
	private static int numKeys;
	
	/**
	 * A variable to store the number of this instance (based off of numKeys at the time of instantiation)
	 */
	private int idNum;
	
//	*******************************************************************************************************************
	
	/**
	 * Constructor to assign the idNum
	 */
	public Key() {
		super(Key.class.getSimpleName());
		numKeys++;
		this.idNum = numKeys;
	}
	
//	*******************************************************************************************************************

	/**
	 * A method to show that there is no requirement to pick up a key.
	 * @return false Return the false to whether or not the key has a requirement in order to be picked up.
	 */
	public boolean hasRequirement() {
		return false;
	}

	/**
	 * A method to tell what requirement is needed to pick up the item.
	 * @return null Return null because there is nothing needed to pick up the key.
	 */
	public String revealRequirement() {
		return null;
	}
	
	/**
	 * A method to access the number attached to this Key Item
	 * @returnidNum 
	 */
	public int getIdNum() {
		return idNum;
	}
	
	/**
	 * A method to get the specific name of a key. 
	 */
	public String getName() {
		return "Key " + idNum;
	}

	/**
	 * @return The Key which will be added to the inventory.
	 */
	public Item getItem() {
		return this;
	
	}
}
