/**
 * @author Robert Warner
 * @author Jo Westarp
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
	 *         Creates the Ghost object at the start location with the symbol
	 *         'G'
	 */

	public Ghost(int location) {
		super('G', location);
	}

	// Player takes hit if one location to the right of Ghost
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (Math.abs(playerLocation - this.getLocation()) <= 1) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;

	}

	// Override move since Ghost implements Moveable
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// Moves Ghost one space to the right as long as nothing is in the way
		int nextLocation = (this.getLocation() + 1) % gameBoard.length;
		while (gameBoard[nextLocation] != null) {
			nextLocation = (nextLocation + 1) % gameBoard.length;
		}
		gameBoard[this.getLocation()] = null;
		gameBoard[nextLocation] = this;
		this.setLocation(nextLocation);
	}

}
