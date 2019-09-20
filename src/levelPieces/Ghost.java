package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Ghost extends GamePiece implements Moveable {

	public Ghost(char symbol, int location) {
		super(symbol, location);

	}

	public Ghost(int location) {
		super('G', location);

	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (playerLocation == this.getLocation()) {
			return InteractionResult.KILL;
		}
		if (Math.abs(playerLocation - this.getLocation()) == 1) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;

	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int nextLocation = (this.getLocation() + 1) % gameBoard.length;
		while (gameBoard[nextLocation] != null) {
			nextLocation = (nextLocation + 1) % gameBoard.length;
		}
		gameBoard[this.getLocation()] = null;
		gameBoard[nextLocation] = this;
		this.setLocation(nextLocation);
	}

}
