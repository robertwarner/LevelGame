package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

//GamePiece that does not move
public class River extends GamePiece {

	public River(char symbol, int location) {
		super(symbol, location);

	}

	public River(int location) {
		super('R', location);

	}

	// Kills player if they land on the river
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (super.getLocation() == playerLocation) {
			return InteractionResult.KILL;
		}

		return InteractionResult.NONE;
	}

}
