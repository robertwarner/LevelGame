/**
 * @author Robert Warner
 * @author Jo Westrap
 */

package levelPieces;

import gameEngine.Moveable;
import gameEngine.Drawable;
import java.util.Random;
import gameEngine.InteractionResult;

//GamePiece that also implements Moveable
public class Ninja extends GamePiece implements Moveable {
	public Ninja(char symbol, int location) {
		super(symbol, location);

	}

	// Use 'X' as symbol for Ninja
	public Ninja(int location) {
		super('X', location);

	}

	// Does HIT of damage when 1-3 spaces away
	// KILL when location == playerLocation
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		int distanceFromPlayer = Math.abs(playerLocation - this.getLocation());
		if (super.getLocation() == playerLocation) {
			return InteractionResult.KILL;
		} else if (distanceFromPlayer >= 1 && distanceFromPlayer <= 3) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}

	// Randomly moves to a place where there is no object.
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		gameBoard[this.getLocation()] = null;
		Random random = new Random();
		int nextLocation = random.nextInt(gameBoard.length);
		while (gameBoard[nextLocation] != null) {
			nextLocation = random.nextInt(gameBoard.length);
		}
		this.setLocation(nextLocation);
		gameBoard[this.getLocation()] = this;
	}

}
