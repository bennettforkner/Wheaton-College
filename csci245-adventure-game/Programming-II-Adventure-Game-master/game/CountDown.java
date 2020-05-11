package game;

/**
 * CountDown.java
 * 
 * Class to count down when facing an enemy.
 *
 * @author AllPassesTests Team
 * Wheaton College, CS 245, Fall 2018
 * Project 4, Adventure Game
 * 
 */

public class CountDown {

	public static void main(String[] args) {
		for (int i = 6; i >= 0; i--) {
			System.out.println(i);
			try { Thread.sleep(1000); } catch (InterruptedException e) {}
		}

	}

}
