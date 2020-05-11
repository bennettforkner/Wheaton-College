package game;

/**
 * Parser.java
 * 
 * Class to interpret the user's commands
 *
 * @author Thomas VanDrunen and AllPassesTests Team
 * Wheaton College, CS 245, Spring 2007, Fall 2018
 * Project 4
 * 
 */

import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap;

public class Parser {
	

	/**
	 * A counter variable to keep track of how many turns have been made
	 */
	public int turn = 0;
	
	/**
	 * 
	 */
	private boolean help = false;
	private boolean list = false;
	private boolean map = false;

	private boolean winIndicator = true;

    /**
     * For user input from the keyboard.
     */
    private Scanner keyboard;

    /**
     * Plain constructor
     */
    public Parser() {
        keyboard = new Scanner(System.in);
    }

    /**
     * Let the user make one "turn" at this game.
     * Give the user a description of the room, prompt for
     * a command, and interpret the command.
     * @param game A reference to the object representing the game.
     * @throws InterruptedException 
     */
    public void executeTurn(Game game){
    	if (turn == 0) {
    		
    		System.out.println(game.getCurrentFloor().getFloorDesc());
	    	HELPER.insPressEnter();
	    	System.out.println("\033[2J");
	    	turn++;
	    
    	} 

        // The room that the user is in.
        Room room = game.getCurrentRoom();
        Floor floor = game.getCurrentFloor();
        
        
//        Map.setVisibleRoom(game); //make the room that the is player in visible on the map
        
        if (!help && !map && !list) {
        	System.out.println(Colors.GREEN + floor.getHint() + Colors.RESET);
        	System.out.println(Colors.YELLOW + "\n  ROOM #" + room.getDescription()+" FLOOR: #" + floor.getFloorNum() + "\n" + Colors.RESET);
        	AsciiArt.makeArt(game);
        }
        else if (help) { //print what commands are available to the player
        	System.out.println("\n  You are in room " + room.getDescription());
            AsciiArt.getKeys();
            help = false; //set help back to false after executing once
        }
        else if (list) { //print what items the player has collected
        	Inventory.list();
        	list = false;
        }
        else if (map) { //print out the map of the rooms that the player has already been to
        	Map.printMap();
        	map = false;
        }
        if (room.getItemInRoom() != null) { //if there is an item in the room
        	if (room.getItemInRoom().getType().compareTo("Enemy") != 0) { //if the item is NOT an enemy, say what it is
        		System.out.println(Colors.CYAN + "\n  << The " + room.getItemInRoom().getType() + " in this room is " + room.getItemInRoom().getName() + " >>\n" + Colors.RESET);
        	}
        	else { //if there IS an enemy in the room, attack the player
            	if (((Enemy) room.getItemInRoom()).attack()) {
            		room.setItemInRoom(null);
            	}
            	else {
            		game.setCurrentRoom(game.getCurrentFloor().getRooms()[4]);
            		room = game.getCurrentRoom();
            		System.out.println(Colors.RESET + "Now you are back in room " + room.getDescription() + "\n" + Colors.CYAN);
            		if (room.getItemInRoom() != null) {
    	        		System.out.println(Colors.CYAN + "\n  << The " + room.getItemInRoom().getType() + " in this room is " + room.getItemInRoom().getName() + " >>\n" + Colors.RESET);
    	        	}
            	}
            }
        }
        else System.out.println(Colors.YELLOW + "\n  << There is nothing in this room >>\n" + Colors.RESET); //if there are no items in the room

        System.out.print(Colors.YELLOW + "  Enter command--> " + Colors.RESET);

        String command = keyboard.nextLine().toLowerCase();  // user's command
        System.out.println("\033[2J");
        

            Room nextRoom = null;   // the room we're moving to
            HashMap<String, Room> helper = room.getDirection();
           
            //Get access to list of all commands from CommandSetter class
            CommandSetter listOfCommands = new CommandSetter();
            HashMap<String,String> com = listOfCommands.getList();
            
            
            if (com.containsKey(command)){ 
            	
            	
	        	switch (com.get(command)) { //based on the command the player has typed, do that
	        		
		            case "north": 
		            		nextRoom = helper.get("north");
		            		break;
		            
		            case "south": 
		            		nextRoom = helper.get("south");
		            		break;
		            
		            case "west": 
		            	nextRoom = helper.get("west");
		            		break;
		            
		            case "east": 
		            		nextRoom = helper.get("east");
		            		break;
		            
		            case "quit": 
		            		winIndicator = false;
		            		nextRoom = room;
		            		game.finishGame();
		            		break;
		            
		            case "help":
		            	nextRoom = new Room("Dont Move");
		            	help = true;
		                break;
		                
		            case "collect":
		            	nextRoom = new Room("Dont Move");
		            	room.pickUpItem();
		            	break;
		            	
		            case "list":
		            	list = true;
		            	nextRoom = new Room("Dont Move");
		            	break;
		            	
		            case "map":
		            	map = true;
		            	nextRoom = new Room("Dont Move");
		            	break;
		            	
		            case "open":
		            	room.openChest();
		            
		            default:
		            	nextRoom = new Room("Dont Move");
	        	}
            
            }else { //if the player types a command that is not available
            	System.out.println(Colors.CYAN + "\n  << I do not know how to do this command:" + command + " >>\n" + Colors.RESET);
            	nextRoom = new Room("Dont Move");
            }
            if (nextRoom == null) { //if there is no room in the direction they are trying to move
                System.out.println(Colors.CYAN + "\n  << Oof! I ran into a wall. I cannot move in that direction. >>\n" + Colors.RESET);
        	}
            else if (nextRoom.getDescription().compareTo("Dont Move") != 0) {
                game.setCurrentRoom(nextRoom);
            }
            
            System.out.print(Colors.RESET);
            
            
    }
    
    public boolean isWon() {
    	return winIndicator;
    }


}
