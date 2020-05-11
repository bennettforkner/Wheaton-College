package game;

import java.util.HashSet;

/**
 * Inventory.java
 * 
 * Non-instantiable Class to act as a storage for the player's collected Items
 *
 * @author AllPassesTests Team
 * Wheaton College, CS 245, Fall 2018
 * Project 4, Adventure Game
 */

public class Inventory {
	
	/**
	 * An ArrayList of Items to represent what the player is holding
	 */
	private static HashSet<Item> inventory = new HashSet<Item>();
	
	/**
	 * A method to access the player's inventory
	 * @return
	 */
	public static HashSet<Item> getInventory() {
		return inventory;
	}
	
	/**
	 * A method to add an Item to the player's inventory
	 * @param i the item to be added
	 */
	public static void addItem(Item item) {
		inventory.add(item);
	}
	
	/**
	 * A method to print out the Items in the inventory formatted correctly
	 */
	public static void list() {
		
		if (inventory.isEmpty()) {
			System.out.println("\n\t<< Your Inventory is empty... >>\n");
			System.out.println("\t<< Press Enter return: >>");
			return; 

		} else {

			System.out.println("\n\t\t<< Inventory: >>");
			int i = 0;
			for(Item item : inventory){
				System.out.println("\t<< Item " + (i) + ": A " + item.getType() + " named " + item.getName() + " >>");
				i++;

			}
		}
		System.out.println();
		return;
	}
	
	/**
	 * A method to check if the player's inventory contains a certain Stairs Item
	 * @param stairNum the number of the Stairs Item to look for
	 * @return true if the specified Stairs Item is in the inventory, else false
	 */
	public static boolean containsStairs() {
		for (Item i: inventory) {
			if (i.getType().compareTo("Stairs") == 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A method to clear the inventory
	 */
	public static void clear() {
		inventory.clear();
	}
}
