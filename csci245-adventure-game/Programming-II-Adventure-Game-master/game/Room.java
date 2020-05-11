package game;

import java.util.*;

/**
 * Room.java
 * 
 * Class to model a room in the game.
 *
 * @author Thomas VanDrunen and AllPassesTests Team
 * Wheaton College, CS 245, Spring 2007 
 * Lab 5 Feb 8, 2007
 * Fall 2018 
 * Project 4, Adventure Game
 * 
 */

public class Room {

	/**
	 * Rooms adjacent to this one, to which there is a door.
	 */
	private HashMap<String, Room> mapOfRoomsAdj = new HashMap<>();

	/**
	 * The Item that exists in the room
	 */
	private Item itemInRoom;

	/**
	 * A description of this room
	 */
	private String description;

//	************************************************************************************
	
	/**
	 * Constructor.
	 * 
	 * @param description A String describing this room to the user.
	 */
	public Room(String description) {
		this.description = description;
	}
	
//	************************************************************************************
	
	private boolean containsItem() {
		if(itemInRoom != null) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Attach an adjacent room by assigning a direction to it.
	 * @param direction The direction that the current room will be associated with
	 * @param adjRoom The adjacent room that will be attached to the current room. 
	 */
	public void setDirection(String direction, Room adjRoom) {
		this.mapOfRoomsAdj.put(direction, adjRoom);
	}
	
	/**
	 * Retrieve a description of this room (to the user).
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the itemInRoom
	 */
	public Item getItemInRoom() {
		return itemInRoom;
	}

	/*
	 * A method to access the HashMap of rooms with their directions for the floor
	 * @return direction
	 */
	public HashMap<String, Room> getDirection() {
		return mapOfRoomsAdj;
	}

	/**
	 * A method to change what Item is stored in the room
	 * @param itemInRoom the itemInRoom to set
	 */
	public void setItemInRoom(Item itemInRoom) {
		this.itemInRoom = itemInRoom;
	}

	
	
	
	
	
	
	
	/**
	 * A method to pick up an Item and place it in the player's inventory
	 * @return the Item held in the room
	 */
	public void pickUpItem() {
		/**
		 * Check to see if there is an item in the room
		 * If there is get the type.
		 * Try to pick up item
		 * 
		 */
		if (this.containsItem()) {
			
			String itemType = itemInRoom.getType();
			
			
			//The item is an Enemy
			if (itemType.equals("Enemy")) {			
				System.out.println("\n<< This Item cannot be picked up >>\n");
				return;
			}

			if (itemType.equals("Chest")) {
				System.out.println("\n<< This Item cannot be picked up >>\n");
				System.out.println("\n\"I need " + itemInRoom.revealRequirement() + " in order to open it.\"\n");
				return;
			}

			
			//If the item doesn't need something in order to be picked up
			// The items that don't have a requirement in order to be picked (and they also aren't a chest/enemy) :
			// 			Key, MapItem, Person (sometimes)
			if (!itemInRoom.hasRequirement()) {
				if (itemType.equals("Stairs")) {
					System.out.println("\n<< Walked Down " + itemInRoom.getName() + " >>\n");
				}else {
					System.out.println("\n<< Picked up: " + itemInRoom.getName() + " >>\n");
				}
				Inventory.addItem(itemInRoom);
				itemInRoom = null;
				return;
			}
			//Adds item to inventory or walks down/up stairs depending on if item is stairs
			
			
			HashSet<Item> inventory = Inventory.getInventory();		// get access to inventory
			for (int itemNum = 0; itemNum < inventory.size(); ) {
				if (itemType.equals("Stairs")) {
					System.out.println("\n<< Walked Down " + itemInRoom.getName() + " >>\n");
				}else {
					System.out.println("\n<< Picked up: " + itemInRoom.getName() + " >>\n");
				}
				Inventory.addItem(itemInRoom);
				itemInRoom = null;
				return;
			}
			if (this.containsItem() && itemInRoom.getType().equals("Chest")) 
				System.out.println("\n\"I need " + itemInRoom.revealRequirement() + " to be opened.\"\n");
			else if (itemInRoom.getType().compareTo("Person") != 0)
				System.out.println("\n\"I need " + itemInRoom.revealRequirement() + " to be activated.\"\n");
			else if (itemInRoom.revealRequirement() != null)
				System.out.println("\n\"I won't leave! "
						+ "I only leave if you have " + itemInRoom.revealRequirement() + " with you.\""
								+ " - " + itemInRoom.getName() + "\n");
			return;
		}

		
	}

	public void openChest() {
		if (itemInRoom != null) {
			System.out.println("\n<< Opened " + itemInRoom.getName() + " >>\n<< Picked up: " + itemInRoom.getItem().getName() + " >>\n");
			Inventory.addItem(itemInRoom.getItem());
			itemInRoom = null;
		}
	}
//		if (itemInRoom != null && itemInRoom.getType().compareTo("Chest") == 0) 
//			System.out.println("\n\t\"I need " + itemInRoom.revealRequirement() + " to be opened.\"\n");
	
	
	
	
	/**
	 * Methods to determine the rooms to which various directions-- if they exist-- lead.
	 */
	public Room getNorth() {
		return mapOfRoomsAdj.get("north");
	}

	public Room getSouth() {
		return mapOfRoomsAdj.get("south");
	}

	public Room getEast() {
		return mapOfRoomsAdj.get("east");
	}

	public Room getWest() {
		return mapOfRoomsAdj.get("west");
	}
	

}
