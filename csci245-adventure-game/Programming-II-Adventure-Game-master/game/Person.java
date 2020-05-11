package game;
/**
 * A class to model a person in the Adventure Game.
 * It is represented as an item and it extends the Item abstract class.
 * 
 * @author AllPassesTests Team
 *
 */
public class Person extends Item {
	
	/**
	 * Name of individual that this person won't leave without
	 */
	private String nOfFriend;
	
	/**
	 * The name of the person.
	 */
	private String name;
	
//	***********************************************************************************************
	
	/**
	 * Constructor.
	 * @param name The name of the person.
	 * @param nOfFriend The name of the friend that the person won't leave the room without.
	 */
	public Person(String name, String nOfFriend) {
		super(Person.class.getSimpleName());
		this.name = name;
		this.nOfFriend = nOfFriend;
	}

//	************************************************************************************************
	
	/**
	 * @return the name of the friend that the Person won't leave the room without
	 */
	public String revealRequirement() {
		return nOfFriend;
	}

	/**
	 * A method to see if a person has a requirement in order to be picked up.
	 */
	public boolean hasRequirement() {
		return (nOfFriend != null);
	}
	
	/**
	 * A method to access the Person's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return The person that is being added to the inventory.
	 */
	public Item getItem() {
		return this;
	}
	
	

}
