package game;

import java.io.IOException;
import java.util.ArrayList;

/**
 * HELPER.java
 * 
 * Class to run repeated code in a more efficient manner
 * Also instantiates Floors
 *
 * @author AllPassesTests Team
 * Wheaton College, CS 245, Fall 2018
 * Project 4, Adventure Game
 */
public class HELPER {

	/*
	 * An ArrayList of Floors to hold all the Floor Objects that will be passed through in the game
	 */
	private static ArrayList<Floor> FLOORS = new ArrayList<>();

	//	******************************************************************************************************************
	
	/**
	 * An accessor method for the Array List FLOORS
	 * @return the array list FLOORS
	 */
	public static ArrayList<Floor> getFloor(){
		return FLOORS;
	}

	/**
	 * A method to create Floor Objects and add them into the FLOORS ArrayList of Floor Objects
	 */
	public static void instantiateFloors() {
		//		FLOOR 1:
		String floorDesc = "\n" + Colors.GREEN
				+ "+----------------------------------------------------------------------------+\n"
				+ "  Welcome to the first floor!\n\n"
				+ "  HINT: THE FLOOR'S NAME IS KAYNE'S CRIB\n"
				+ "  You're currently in a room with 4 doors on each side of you\n"
				+ "  You notice smoke curling out from under them!\n\n  Enter 'help' for a list of commands\n"
				+ "+----------------------------------------------------------------------------+"
				+ Colors.RESET;
		String floorHint = "HINT: THE FLOOR'S NAME IS KAYNE'S CRIB";
		
		//		add all floor items
		ArrayList<Item> floorItemsList = new ArrayList<>();
		floorItemsList.add(new Person("Kim", "North West"));
		floorItemsList.add(new Person("North West", null));
		floorItemsList.add(new Person("Kanye", "Kim"));
		floorItemsList.add(new Stairs("Kanye"));

		//		add both list of items and floor description to first floor
		FLOORS.add(new Floor(floorItemsList,floorDesc, floorHint));
		floorItemsList.clear();

		//		FLOOR 2:

		floorDesc = "\n" + Colors.GREEN 
				+ "+----------------------------------------------------------------------------+\n"
				+ "  Welcome to the second floor!\n\n"
				+ "  HINT: You may run into Enemies on this floor...\n"
				+ "  You're currently in a room with 4 doors on each side of you\n"
				+ "  There are three team members stuck on the floor and you have to get them out.\n\n"
				+ "  Watch out for Enemies!\n\n  Enter 'help' for a list of commands\n"
				+ "+----------------------------------------------------------------------------+"
				+ Colors.RESET;

		floorHint = "HINT: YOU MAY RUN INTO ENEMIES ON THIS FLOOR!";
		
		floorItemsList.add(new Person("Bennett", "Lauren"));
		floorItemsList.add(new Enemy(getRandomEnemyName(), getRandomEnemyDif(), new Person("Lauren", null)));
		floorItemsList.add(new Person("Elliot", "Bennett"));
		floorItemsList.add(new Stairs("Elliot"));
		FLOORS.add(new Floor(floorItemsList,floorDesc, floorHint));
		floorItemsList.clear();

		//		FLOOR 3:

		floorDesc = "\n" + Colors.GREEN
				+ "+----------------------------------------------------------------------------+\n"
				+ "  Welcome to the third floor!\n\n"
				+ "  You're currently in a room with 4 doors on each side of you\n"
				+ "  There is a key, a chest, and two people on this floor.\n\n"
				+ "  Find the key!\n\n  Enter 'help' for a list of commands\n"
				+ "+----------------------------------------------------------------------------+"
				+ Colors.RESET;

		floorHint = "HINT: FIND THE KEYS!";
		
		Key k = new Key();
		floorItemsList.add(new Enemy(getRandomEnemyName(), getRandomEnemyDif(), "Ha, I will defeat you now", k));
		floorItemsList.add(new Chest(k,new Person("Kevin", null)));
		floorItemsList.add(new Person("Stacy","Kevin"));
		floorItemsList.add(new Stairs("Stacy"));
		FLOORS.add(new Floor(floorItemsList,floorDesc, floorHint));
		floorItemsList.clear();

//              FLOOR 4:

        floorDesc = "\n" + Colors.GREEN
        				+ "+----------------------------------------------------------------------------+\n"
                        + "  Welcome to the fourth floor!\n\n"
        				+ "  You're currently in a room with 4 doors on each side of you\n"
                        + "  There are three \"people\" on this floor.\n\n"
                        + "  Find the key!\n\n  Enter 'help' for a list of commands\n"
                        + "+----------------------------------------------------------------------------+"
                        + Colors.RESET;

        floorHint = "HINT: SAVE THE PEOPLE IN ORDER!";
                
        floorItemsList.add(new Enemy("Dr. Pohly", 3, "MY CODING SKILLS SURPASS ANY KNOWLEDGE YOU MAY HAVE!!!", new Person("Aleksandr Glavinik", null)));
        floorItemsList.add(new Person("The CSCI 245 class", "Alexsandr Glavinik"));
        floorItemsList.add(new Person("Ryken","The CSCI 245 class"));
        floorItemsList.add(new Stairs("Ryken"));
        FLOORS.add(new Floor(floorItemsList,floorDesc, floorHint));
        floorItemsList.clear();
        
	}

	private static class EnemyNames{
		private ArrayList<String> names = new ArrayList<>();
		
		private void addNames() {
			names.add("The Killer");
			names.add("The Slasher");
			names.add("The Pounder");
			names.add("Monster");
			names.add("The Joker");
			names.add("Two Face");
			names.add("The Hash-Slinging Slasher");
			names.add("Dr. Pohly");
			names.add("Your Mom");
		}
		
		public ArrayList<String> returnNames(){
			addNames();
			return names;
			
		}
	}
	/**
	 * A helper method to return a random enemy name
	 * @return a random enemy name
	 */
	private static String getRandomEnemyName() {
		ArrayList<String> listOfNames = new EnemyNames().returnNames();
		return listOfNames.get((int)(Math.random() * listOfNames.size()));
	}
	
	/**
	 * A simple helper method to return a random value for the difficulty of an enemy. 
	 * @return a random difficulty level for the enemy.
	 */
	private static int getRandomEnemyDif() {
		return (int)(Math.random() * 3) + 1;
	}
	
	/**
	 * A helper method to insert the Press Enter feature.
	 */
	public static void insPressEnter() {
		System.out.print(Colors.RESET + "\n\n  Press Enter to continue." );
		try {
    		System.in.read();
    	} catch (IOException e) {
    		e.printStackTrace(); 
    	}
	}
}
