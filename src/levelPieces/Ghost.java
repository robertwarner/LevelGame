/**
 * @author Robert Warner
 * @author Jo Westrap
 * 
 * Ghost is a GamePiece that is also moveable
 * 
 */


package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

/*
 * Is-A GamePiece and implements Moveable
 */

public class Ghost extends GamePiece implements Moveable {

	public Ghost(char symbol, int location) {
		super(symbol, location);

	}
	
	/**
	 * @param location
	 * @return
	 * 
	 * Creates the Ghost object at the start location with the symbol 'G'
	 */

	public Ghost(int location) {
		super('G', location);

	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		//Player dies if Ghost and player are on same location
		if (playerLocation == this.getLocation()) {
			return InteractionResult.KILL;
		}
		
		//Player takes hit if one location away from Ghost
		if (Math.abs(playerLocation - this.getLocation()) == 1) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;

	}

	//Override move since Ghost implements Moveable
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		//Moves Ghost one space to the right as long as nothing is in the way
		int nextLocation = (this.getLocation() + 1) % gameBoard.length;
		while (gameBoard[nextLocation] != null) {
			nextLocation = (nextLocation + 1) % gameBoard.length;
		}
		gameBoard[this.getLocation()] = null;
		gameBoard[nextLocation] = this;
		this.setLocation(nextLocation);
	}

}
