/**
 * @author Robert Warner
 * @author Jo Westrap
 * 
 */

package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import gameEngine.Player;

public class LevelEngine {
	
	private int levelLength;
	private Drawable[] level;
	private ArrayList<Moveable> moveablePieces;
	private ArrayList<GamePiece> interactingPieces;

	
	public LevelEngine() {
		super();
		this.levelLength = GameEngine.BOARD_SIZE;
		moveablePieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>(0);
	}
	
	/**
	 * 
	 * @return Drawable[] to represent level
	 */
	
	private Drawable[] level1() {
		//Level initialization
		this.level = new Drawable[levelLength];
		interactingPieces.clear();
		moveablePieces.clear();
		
		//Add Drawable piece to level array
		this.level[5] = new Flower();
		//Add GamePieces that do not move to associated ArrayList
		interactingPieces.add(new River(8));
		interactingPieces.add(new Treasure(12));
		interactingPieces.add(new Portal(20));
		//Add GamePieces that move to both ArrayLists
		Ghost ghost = new Ghost(18);
		moveablePieces.add(ghost);
		interactingPieces.add(ghost);
		
		//Add all GamePieces to drawable array at their starting locations		
		for(GamePiece interactingPiece : interactingPieces) {
			this.level[interactingPiece.getLocation()] = interactingPiece;
		}
		
		//Return completed level of Drawables
		return level;
	}
	
	private Drawable[] level2() {
		//Initialize level2
		this.level = new Drawable[levelLength];
		interactingPieces.clear();
		moveablePieces.clear();
		
		//Add GamePieces to ArrayLists (These do not move)
		interactingPieces.add(new River(10));
		interactingPieces.add(new River(12));
		interactingPieces.add(new River(14));
		interactingPieces.add(new River(16));
		interactingPieces.add(new River(18));
		interactingPieces.add(new Treasure(20));
		

		//Add moveable GamePieces to ArrayLists
		Ghost ghost = new Ghost(6);
		moveablePieces.add(ghost);
		interactingPieces.add(ghost);
	
		
		Ninja  ninja = new Ninja(19);
		moveablePieces.add(ninja);
		interactingPieces.add(ninja);

		//Add all GamePieces to Drawable array at starting locations
		for(GamePiece interactingPiece : interactingPieces) {
			this.level[interactingPiece.getLocation()] = interactingPiece;
		}
		
		
		return level;
	}
	
	/**
	 * Returns the level associated with levelNum
	 * @param levelNum
	 */
	public void createLevel(int levelNum) {
		this.level = null;
		switch(levelNum) {
		case 1:
			this.level = level1();
			break;
		case 2:
			this.level = level2();
			break;
		default:
			//Blank Level
			this.level = new Drawable[levelLength];
			break;
		}
		
	}
	/**
	 * @return ArrayList of all the moveable objects in the level
	 */
	public ArrayList<Moveable> getMovingPieces() {
		return moveablePieces;
	}
	/**
	 * @return Arraylist of all GamePieces in the level
	 */
	public ArrayList<GamePiece> getInteractingPieces(){
		return interactingPieces;
		
	}

	/**
	 * @return returns the Drawable objects of the current level
	 */
	public Drawable[] getBoard() {
		return this.level;
	}

	public int getPlayerStartLoc() {
		return 0;
	}
	
	
	
}
