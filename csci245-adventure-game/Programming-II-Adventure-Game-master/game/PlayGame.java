package game;
/**
 * PlayGame.java
 * 
 * Program to control the playing of this game.
 *
 * @author Thomas VanDrunen and AllPassesTests Team
 * Wheaton College, CS 245, Spring 2007 Lab 5 Feb 8, 2007
 * Fall 2018
 * Project 4, Adventure Game
 * 
 */

public class PlayGame {

	static long startTime = System.currentTimeMillis();

	public static void main(String[] args) throws InterruptedException {

		System.out.println("\033[2J");
		System.out.println("  Welcome to AllPassesTest's Adventure Game!\n"); 
		Thread.sleep(2000);
		System.out.print("  You're on a rescue squad which is currently trying to save people"
				+ " trapped in a ");
		Thread.sleep(2500);
		System.out.print(Colors.YELLOW + "BURNING APPARTMENT BUILDING!" + Colors.RESET);
		Thread.sleep(1000);
		System.out.print("\n\n  None of you want to enter the building...");
		Thread.sleep(2000);
		System.out.print(" s");
		Thread.sleep(500);
		System.out.print("o");
		Thread.sleep(500);
		System.out.print("o");
		Thread.sleep(500);
		System.out.print("o");
		Thread.sleep(3000);
		System.out.println(Colors.RED + "\n\n\n  YOU ALL DRAW STRAWS TO SEE WHO HAS TO GO IN!\n" + Colors.RESET);
		Thread.sleep(3000);
		System.out.println("  The straws are being drawn now!\n\n");
		Thread.sleep(1500);
		System.out.print("\t  .");
		Thread.sleep(1000);
		System.out.print(" .");
		Thread.sleep(1000);
		System.out.print(" .");
		Thread.sleep(1000);
		System.out.print(" .");
		Thread.sleep(2000);
		System.out.print(" .");
		Thread.sleep(2000);
		System.out.println(Colors.CYAN + "\n\n  You've been thrown into one of the building windows "
				+ "by your rescue squad \"friends\"...\n" + Colors.RESET);
		Thread.sleep(3000);
		System.out.println(Colors.YELLOW + "  GO SAVE SOME HELPLESS TENNANTS!" + Colors.RESET); 
		Thread.sleep(3000);
		System.out.println("\n\n");
		AsciiArt.getKeys();
		HELPER.insPressEnter();
		System.out.println("\033[2J");

		Game game = new Game();   // reference to the game object
		game.Play();
		double endTime = System.currentTimeMillis();
		if(!game.wasQuit()) {
			System.out.println(Colors.GREEN + "  <<You saved all the helpless tennants! Congragulations!>>");
			System.out.println("  <<SCORE: You finished in " + ((endTime-startTime)/1000) + " seconds!>>");
			System.out.println("  <<Game Over>>\n\n");
		} else {
			System.out.println("  <<SCORE: You finished in " + ((endTime-startTime)/1000) + " seconds!>>");
			System.out.println(Colors.RED + "  <<Game Over>>\n\n");
		}
	}

}
