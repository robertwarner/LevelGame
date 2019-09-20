package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Portal extends GamePiece {

	public Portal(char symbol, int location) {
		super(symbol, location);
	}

	public Portal(int location) {
		super('@', location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (super.getLocation() == playerLocation) {
			
			return InteractionResult.ADVANCE;
		}
		return InteractionResult.NONE;
		
	}

}