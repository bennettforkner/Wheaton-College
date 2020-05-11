package game;

/**
 * A class to represent the Map Item in the Adventure Game.
 * It extends the abstract class Item.
 * @author AllPassesTests Team
 * Project 4, Adventure Game
 *
 */
public class MapItem extends Item {
	
	/*
	 * The floor number that the map represents.
	 */
	private int floorNum;
	
//	*********************************************************************************
	
	/**
	 * Constructor.
	 * @param floorNum The floor number that the MapItem will hold information on.
	 */
	public MapItem(int floorNum) {
		super(MapItem.class.getSimpleName());
		this.floorNum = floorNum;
	}
	
//	*********************************************************************************
	
	/**
	 * A method to get the name of the Map.
	 * @return name The name of the Map and the floor number that it is on.
	 */
	public String getName() {
		return "Map #" + floorNum;
	}
	/**
	 * A method to see if a MapItem has a requirement in order to be collected.
	 * @return false The MapItem has no requirement in order to be collected.
	 */
	public boolean hasRequirement() {
		return false;
	}
	
	/**
	 * A method to reveal the requirement needed to pick up the the MapItem.
	 * @return null There is no requirement needed to collect the MapItem.
	 */
	public String revealRequirement() {
		return null;
	}
	
	/**
	 * A method to reveal all the rooms on the floor.
	 * @param roomsOnFloor The boolean array which holds the information on which rooms are visible.
	 */
	public void revealRooms(boolean[] roomsOnFloor) {
		for(int i = 0; i<roomsOnFloor.length; i++)
			roomsOnFloor[i] = true;
	}

	/**
	 * @return the Map Item that will be added to the inventory.
	 */
	public Item getItem() {
		return this;
	
	}
}
