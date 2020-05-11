package game;

import java.util.ArrayList;

/**
 * Floor.java
 * 
 * Class to aggregate the rooms on a particular floor and instantiate their connections
 *
 * @author AllPassesTests Team
 * Wheaton College, CS 245, Fall 2018
 * Project 4, Adventure Game
 * 
 */

public class Floor {

	/**
	 * An ArrayList of Items to represent the items that will be in the rooms of the floor (randomly placed later)
	 */
	private ArrayList<Item> itemsOnFloor;
	
	/**
	 * A static int variable to hold the total number of floors built
	 */
	private static int count = 0;
	
	/**
	 * An int variable to hold the floor object's number (based off of count at time of instantiation)
	 */
	private int floorNum;
	
	/**
	 * An array of Room objects to store the rooms on the floor
	 */
	private Room[] rooms = new Room[9];
	
	/**
	 * A String variable to be printed when the floor is entered by the player
	 */
	private String floorDesc;
	
	/**
	 * A hint about what will be on the floor.
	 */
	private String floorHint;
	
	/**
	 * The constructor of a new Floor Object
	 * Instantiates rooms, their relations, and the Items that they contain
	 * @param itemsOnFloor (see itemsOnFloor)
	 * @param fD (see floorDesc)
	 */
	public Floor(ArrayList<Item> itemsOnFloor, String floorDescription, String floorHint) {
		this.floorDesc = floorDescription;
		this.itemsOnFloor = itemsOnFloor;
		count++;
		this.floorNum = count;
		this.floorHint = floorHint;
		for (int i = 0; i < rooms.length; i++)
			rooms[i] = new Room(""+i);

		// a rough look at the floor layout
		// -------
		// -0-1-2-
		// -3-4-5-
		// -6-7-8-
		// -------

		// Make a room at position 0
		rooms[0].setDirection("south",rooms[3]);
		rooms[0].setDirection("east",rooms[1]);
		
		// Make a room at position 1
		rooms[1].setDirection("south",rooms[4]);
		rooms[1].setDirection("west",rooms[0]);
		rooms[1].setDirection("east",rooms[2]);
		
		// Make a room at position 2
		rooms[2].setDirection("south",rooms[5]);
		rooms[2].setDirection("west",rooms[1]);
		
		// Make a room at position 3
		rooms[3].setDirection("north",rooms[0]);
		rooms[3].setDirection("south",rooms[6]);
		rooms[3].setDirection("east",rooms[4]);
		
		// Make a room at position 4
		rooms[4].setDirection("north",rooms[1]);
		rooms[4].setDirection("south",rooms[7]);
		rooms[4].setDirection("west",rooms[3]);
		rooms[4].setDirection("east",rooms[5]);

		// Make a room at position 5
		rooms[5].setDirection("north",rooms[2]);
		rooms[5].setDirection("south",rooms[8]);
		rooms[5].setDirection("west",rooms[4]);
		
		// Make a room at position 6
		rooms[6].setDirection("north",rooms[3]);
		rooms[6].setDirection("east",rooms[7]);
		
		// Make a room at position 7
		rooms[7].setDirection("north",rooms[4]);
		rooms[7].setDirection("east",rooms[8]);
		rooms[7].setDirection("west",rooms[6]);
		
		// Make a room at position 8
		rooms[8].setDirection("north",rooms[5]);
		rooms[8].setDirection("west",rooms[7]);
		
		int numItems = itemsOnFloor.size();
		ArrayList<Integer> randomRooms = new ArrayList<Integer>();
		for (int i = 0; i < numItems; i++) {
			int random = (int)(Math.random() * 9);
			while (randomRooms.contains(random)) {
				random = (int)(Math.random() * 9);
			}
			randomRooms.add(random);
		}
		for (int i = 0; i < randomRooms.size(); i++)
			rooms[randomRooms.get(i)].setItemInRoom(this.itemsOnFloor.get(i));
	}

	/**
	 * A method to access the array of Room Objects
	 * @return "rooms" (array of Room Objects)
	 */
	public Room[] getRooms() {
		return rooms;
	}
	
	/**
	 * A method to access the number of this floor
	 * @return floorNum
	 */
	public int getFloorNum() {
		return floorNum;
	}

	/**
	 * A method to access the description of the floor
	 * @return the floorDesc
	 */
	public String getFloorDesc() {
		return floorDesc;
	}
	
	/**
	 * Returns the floor hint.
	 * @return String the floor hint.
	 */
	public String getHint() {
		return floorHint;
	}
}
