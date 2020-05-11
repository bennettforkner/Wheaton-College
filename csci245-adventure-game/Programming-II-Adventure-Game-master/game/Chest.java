package game;

/**
 * Chest.java
 * 
 * Class to model a chest item that holds another item inside and is unlocked by a Key Item
 *
 * @author AllPassesTests Team
 * Wheaton College, CS 245, Fall 2018
 * Project 4, Adventure Game
 * 
 */

public class Chest extends Item {
	
	/**
	 * The Item held inside this chest
	 */
	private Item contents;
	
	/**
	 * The Key that this chest requires in order to be opened
	 */
	private Key keyRequired;

//	******************************************************************************************************
	
	/**
	 * Constructor to instantiate values of the instance variables
	 * @param req The key needed to open the chest
	 * @param contents The Item which will be contained in the chest
	 */
	public Chest(Key req, Item contents) {
		super(Chest.class.getSimpleName());
		this.keyRequired = req;
		this.contents = contents;
	}
	
//	******************************************************************************************************
	
	/**
	 * A method to see which chest the player has come across. 
	 * @return The name of the chest and it's corresponding number. 
	 */
	public String getName() {
		return "Chest " + keyRequired.getIdNum();
	}

	/**
	 * A method to show that there is no requirement to pick up a key.
	 * @return true if the key exists and false if it is null
	 */
	public boolean hasRequirement() {
		return (this.keyRequired != null);
	}

	/**
	 * A method to show the requirement needed to pick up a key.
	 * @return the requirement if there is one
	 */
	public String revealRequirement() {
		if (this.hasRequirement()) { //if the player needs to do something to pick up a key
			return "Key " + keyRequired.getIdNum();
		}else { 
			return "";
		}
	}
	
	/**
	 * A method to reveal what item is in the chest.
	 * @return the item in the chest
	 */
	public Item getItem() {
		return contents;
	}
}
