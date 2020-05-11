package game;

/**
 * Map.java
 * 
 * Creates a map to print what rooms the user has already been in.
 * Also should be used to print all the rooms on the floor when the proper
 * map item has been found.
 * 
 * @author AllPassesTests Team
 * Wheaton College, CS 245, Fall 2018
 * Project 4, Adventure Game
 */

public class Map{
	
	/**
	 * A boolean array to keep track of what rooms the player has been in.
	 */
	private static boolean[] roomsOnFloor = new boolean[9];
	
	/**
	 * The current room that the player is in.
	 */
	private static int room;
	
	/**
	 * A method to set the current room that the user is in to true.
	 * @param game A reference to the object of the current game
	 */
	public static void setVisibleRoom(Game game) {
		roomsOnFloor[room] = true;
	}
	
	/**
	 * A method to print the rooms that the player has been to upon wanting to see the map.
	 */
	public static void printMap() {
		System.out.println("  You have been to these rooms: ");
		for (int i=0; i < 9; i++) { 
			System.out.println("  Room " + i + ": " + roomsOnFloor[i]);
		}
	}
	
	/**
	 * A method to clear the map when moving to a new floor.
	 */
	public static void clearMap() {
		for (int i=0; i<9; i++) 
			roomsOnFloor[i] = false;
	}
	
	
}