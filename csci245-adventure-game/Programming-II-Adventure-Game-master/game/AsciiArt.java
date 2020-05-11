package game;

/**
 * AsciiArt.java
 * 
 * Class for a visual depiction of what room the player is in.
 *
 * @author Thomas VanDrunen and AllPassesTests Team
 * Wheaton College, CS 245, Spring 2007 Lab 5 Feb 8, 2007
 * Fall 2018
 * Project 4, Adventure Game
 * 
 */

public class AsciiArt {

	public static String makeArt(Game game){
		String room = game.getCurrentRoom().getDescription();
		String Ascii = null;
		System.out.print(Colors.BLUE + "	---" + Colors.YELLOW + "MAP" + Colors.BLUE + "---"); 
		for(int i = 0; i<9; i++){
			if(i == 0 || i == 3 || i == 6)
				System.out.print("\n	");

			if(room.equals("" + i)) {
				System.out.print(" ");
				System.out.print(Colors.YELLOW);
				System.out.print("" + i);
				System.out.print(Colors.BLUE);
				System.out.print(" ");
			}
			else {
				System.out.print(" " + i + " ");
			}
			

		}
		System.out.println(     "\n	---------"); 

		return Ascii;
	}
	
	public static void getKeys(){
 
		System.out.println("  Controls:\n");
		System.out.println("  MOVEMENTS:");
		System.out.println("   [W]--up           "); 
		System.out.println("   [A]--left         "); 
		System.out.println("   [S]--down         "); 
		System.out.println("   [D]--right        ");
		System.out.println(""); 
		System.out.println("  ABILITIES:");
		System.out.println("   [O]--open a chest"); 
		System.out.println("   [I]--check your inventory"); 
		System.out.println("   [C]--collect a person / use a stairwell");
		System.out.println("   'quit' or 'exit' --exit the game :(");
		System.out.println("   'help' --get this list of commands!");

		

	}
}
