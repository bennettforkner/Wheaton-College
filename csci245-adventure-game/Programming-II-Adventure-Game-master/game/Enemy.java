package game;

import java.util.Scanner;
//import java.io.IOException;
import java.util.Date;

/**
 * Class to model an Enemy.
 * It is represented as an Item that exists in a room and will attack the player.
 *
 * @author AllPassesTests Team
 * Wheaton College, CS 245, Fall 2018
 * Project 4, Adventure Game
 * 
 */

public class Enemy extends Item {
	
	/**
	 * An integer variable (1-3) to tell how difficult an enemy is
	 */
	private int difficulty = 1;
	
	/**
	 * The name of the Enemy
	 */
	private String name;
	
	/**
	 * The String that the Enemy says when provoked
	 */
	private String taunt = Colors.RED + "\n\t\"Ha! You have fallen into my trap for you! "
			+ "You will never defeat me!\"\n";
	
	/**
	 * The Item that the Enemy will drop if killed
	 */
	private Item holding = null;
	
//	******************************************************************************************************
	
	//SIX possible constructors
	
	/**
	 * An Enemy with... default: difficulty level, taunt, and no item |  specialized: name.
	 * @param name The name to be assigned to the enemy
	 */
	public Enemy(String name) {
		super(Enemy.class.getSimpleName());
		this.name = name;
	}

	/**
	 * An Enemy with... default: taunt and no item |  specialized: name and difficulty level.
	 * @param name The name to be assigned
	 * @param diff The difficulty to be assigned
	 */
	public Enemy(String name, int diff) {
		super(Enemy.class.getSimpleName());
		this.difficulty = diff;
		this.name = name;
	}
	
	/**
	 * An Enemy with... default: no item | specialized: name, difficulty level, and taunt
	 * @param name The name to be assigned
	 * @param diff The difficulty to be assigned
	 * @param taunt The taunt to be assigned
	 */
	public Enemy(String name, int diff, String taunt) {
		super(Enemy.class.getSimpleName());
		this.difficulty = diff;
		this.name = name;
		this.taunt = taunt;
	}
	
	/**
	 * An Enemy with... default: difficulty level and taunt | specialized: name and item.
	 * @param name The name to be assigned
	 * @param diff The difficulty to be assigned
	 * @param holding The Item holding to be assigned
	 */
	public Enemy(String name, Item holding) {
		super(Enemy.class.getSimpleName());
		this.name = name;
		this.holding = holding;
	}

	/**
	 * An Enemy with... default: taunt | and specialized: name, difficulty level, and item.
	 * @param name The name to be assigned
	 * @param diff The difficulty to be assigned
	 * @param holding The Item holding to be assigned
	 */
	public Enemy(String name, int diff, Item holding) {
		super(Enemy.class.getSimpleName());
		this.difficulty = diff;
		this.name = name;
		this.holding = holding;
	}
	
	/**
	 * An Enemy with... default: |  specialized: name, difficulty level, taunt, and item.
	 * @param name The name to be assigned
	 * @param diff The difficulty to be assigned
	 * @param holding The Item holding to be assigned
	 * @param taunt The taunt to be assigned
	 */
	public Enemy(String name, int diff, String taunt, Item holding) {
		super(Enemy.class.getSimpleName());
		this.difficulty = diff;
		this.name = name;
		this.holding = holding;
	}
	
//	************************************************************************************************
	
	/**
	 * A method to get the name of the Enemy.
	 * @return name The name of the Enemy.
	 */
	public String getName() {
		return name;
	}

	

	/**
	 * A method to see if an Enemy has a requirement in order to be collected.
	 * @return false The Enemy has no requirement in order to be collected.
	 */
	public boolean hasRequirement() {
		return false;
	}

	/**
	 * A method to reveal the requirement needed to pick up the Enemy.
	 * @return null There is no requirement needed to collect the Enemy.
	 */
	public String revealRequirement() {
		return null;
	}

	/**
	 * A method to simulate an attack from the enemy
	 * @return true if enemy is defeated, else false
	 * @throws InterruptedException
	 */

	public boolean attack() {
		System.out.println(Colors.RED + "\n\t<< THE ENEMY, " + name + ", IS IN THIS ROOM! "
				+ "Their difficulty level is " + difficulty + " >>");
		
		if(holding!=null) {
			System.out.println("\t\t\t   << " + name + " is holding a " + holding.getType() + " >>");
		} else {
			System.out.println("\t\t\t   << There is nothing in their hands >>");
		}
		
		System.out.println("\n\t<< In order to defeat " + name + ", you must copy the numbers that they type >>");
		System.out.println("\t\t\t<< then press <ENTER> in less than 7 seconds >>");
		System.out.println(Colors.RESET + "\n\n\t<< WAIT UNTIL ALL THE NUMBERS HAVE BEEN TYPED BEFORE YOU COPY THEM>>");
		
		HELPER.insPressEnter();
		
		System.out.println(taunt + Colors.CYAN);
		
		Scanner in = new Scanner(System.in);
		try { Thread.sleep(4000); } catch (InterruptedException e) {}
		String code = "";
		System.out.print("\t\t\t\t");
		for (int i = 0; i < difficulty * 3; i++) {
			int r = (int)(Math.random() * 10);
			System.out.print(r);
			code += r;
			try { Thread.sleep(750); } catch (InterruptedException e) {}
		}
		System.out.print(Colors.YELLOW + "\n  Copy --> \t\t\t" + Colors.RESET);
		Date d = new Date();
		
		long before = d.getTime();
		String entered = in.nextLine();
		d = new Date();
		int time = (int)(d.getTime() - before);
		System.out.print(Colors.CYAN);
		if (entered.equals(code) && time <= 7000) {
			System.out.println("\n\t<< " + name + " Defeated! >>");
			if (holding != null) {
				try {Thread.sleep(2000);} catch (InterruptedException e) {}
				System.out.println("\n\t<< " + name + " dropped something... you picked it up. >>");
				try { Thread.sleep(2000); } catch (InterruptedException e) {}
				System.out.println("\n\t<< Picked up: " + holding.getName() + " >>\n");
				Inventory.addItem(holding);
			}
			return true;
		}
		else if (entered.equals(code) && time > 7000) {
			System.out.println("\n\t<< You took too long and " + name + " defeated you >>\n");
			return false;
		}
		else if (!entered.equals(code) && entered.compareTo(code) > -5) {
			System.out.println("\n\t<< So close! Please try again >>\n");
			return false;
		}
		else {
			System.out.println("\n\t<< Not even close! Try again >>\n");
			return false;
		}
		
	}

	/**
	 * @return the enemy?
	 */
	public Item getItem() {
		return this;
	}

}
