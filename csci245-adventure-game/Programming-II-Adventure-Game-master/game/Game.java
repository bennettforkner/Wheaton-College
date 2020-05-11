package game;

import java.util.ArrayList;

/**
 * Game.java
 * 
 * Class to model the game as a collection of rooms. The rooms are organized as
 * a graph, and the Room objects are nodes in the graph.
 *
 * @author Thomas VanDrunen and AllPassesTests Team
 * Wheaton College, CS 245, Spring 2007 Lab 5 Feb 8, 2007
 * Project 4, Adventure Game
 * 
 */


public class Game {

	/**
	 * The current room the user is in. 
	 * This serves two purposes: 
	 * 1. it is our only permanent connection to the rooms in this game 
	 * (the other rooms are reachable by traversing this room's "doors")
	 * 2. it maintains the state by representing the user's current location.
	 */
	private Room currentRoom;

	/**
	 * Keeps track of whether this game is over or not.
	 */
	private boolean over;
	
	/**
	 * An ArrayList of Floors to represent the floors in the building
	 */
	private ArrayList<Floor> floors;

	/**
	 * The current floor that the player is on
	 */
	private Floor currentFloor;
	
	private boolean wasQuit;
	

//	****************************************************************************************************************************
	
	/**
	 * Constructor to set up the game.
	 * Uses HELPER class to do most of the work.
	 * Contains the code which calls "Play"
	 * @throws InterruptedException 
	 */
	public Game() throws InterruptedException {
		over = false;
		HELPER.instantiateFloors();
		floors = HELPER.getFloor();
		
	}
	
//	*****************************************************************************************************************************
	
	/**
	 * Return the room in which the user is currently.
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	
	/**
	 * A method to run through floors of the game
	 */
	public void Play() {
		while (floors.size() != 0) {	//precaution? floor size will never be zero?
			currentFloor = floors.remove((int)(Math.random() * floors.size()));
			currentRoom = currentFloor.getRooms()[4];
			beginParsing();
			Inventory.clear();
			Map.clearMap();
			wasQuit = new Parser().isWon();
        }
		return;
	}
	
	private void beginParsing() {
		Parser parser = new Parser();
		while (!over && !Inventory.containsStairs()) {
			parser.executeTurn(this);
		}
	}
	
	/**
	 * Is this game over or not?
	 */
	public boolean isOver() {
		return over;
	}

	/**
	 * Move into a different current room.
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	/**
	 * A method to access the floor that the player is currently on
	 * @return currentFloor
	 */
	public Floor getCurrentFloor() {
		return currentFloor;
	}

	public ArrayList<Floor> getListOfFloors() {
		return floors;
	}
	
	/**
	 * Indicate that the game is now over.
	 */
	public void finishGame() {
		over = true;
	}
	
	public boolean wasQuit() {
		return wasQuit;
	}

}
