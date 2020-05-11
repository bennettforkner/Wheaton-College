package game;


/**
 * Item.java
 * 
 * Class for data about items in a room.
 *
 * @author AllPassesTests Team
 * Wheaton College, CS 245, Fall 2018
 * Project 4, Adventure Game
 */


public abstract class Item {
	
	/**
	 * The type of item it is.
	 */
	private String type;
	
	/**
	 * Constructor to instantiate the instance variable for type of object.
	 * @param type the type of the object
	 */
	public Item(String type) {
		this.type = type;
	}

	/**
	 * A method to return a String value of what class the object is from
	 * 
	 * @return the type of the object
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * A method to return a String value of what class the object is from
	 * 
	 * @return the type of the object
	 */
	public abstract String getName();
	
	/**
	 * A method to tell if the item needs something in order to be picked up
	 * 
	 * @return true if there is a required object, else false
	 */
	public abstract boolean hasRequirement();

	/**
	 * A method to tell what item the item needs in order to be picked up
	 * 
	 * @return the required object
	 */
	public abstract String revealRequirement();
	
	/**
	 * A method used to access the part of an item that can be added to a players inventory.
	 */
	
	public abstract Item getItem();
}
