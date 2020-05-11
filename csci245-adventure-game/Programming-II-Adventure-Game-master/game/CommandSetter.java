package game;
/**
 * CommandSetter.java
 * 
 * A class to set all the commands for the game
 * 
 * @author AllPassesTests Team
 * Wheaton College, CS 245, Fall 2018
 * Project 4, Adventure Game
 * 
 */

import java.util.HashMap;

public class CommandSetter {

	/**
	 * A map of a number of commands which could be simplified as one command. 
	 */
	private HashMap<String,String> com;

	/**
	 * A constructor to initialize all the commands that can be used in the game.
	 */
	public CommandSetter(){
		com = new HashMap<>(); //a Hashmap that holds all of the possible commands for the game
		
		//commands which map to going north
		com.put("up", "north");
		com.put("w", "north");

		//commands which map to going south
		com.put("down", "south");
		com.put("s", "south");

		// commands which map to going west
		com.put("left", "west");
		com.put("a", "west");

		// commands which map to going east
		com.put("d", "east");
		com.put("right", "east");


		//commands which map to quitting
		com.put("Quit", "quit");
		com.put("quit", "quit");
		com.put("Exit", "quit");
		com.put("exit", "quit");
		
		
		com.put("Help", "help"); //commands which map to print directions
		com.put("help", "help");

		com.put("m", "map"); //commands which map to show the map of the floor
		com.put("M", "map");
		com.put("map", "map");
		com.put("Map", "map");

		com.put("c", "collect"); //commands to collect an Item from a room

		//commands to list the Items in the player's inventory
		com.put("i", "list");

		com.put("o", "open");
	}
	
	/**
	 * A getter method for the list of possible inputs.
	 * @return HashMap of mapped commands.
	 */
	public HashMap<String,String> getList() {
		return com;
	}
}
