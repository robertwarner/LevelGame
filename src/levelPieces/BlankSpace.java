package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class BlankSpace extends GamePiece {

	public BlankSpace(char symbol, int location) {
		super(symbol, location);
	}
	public BlankSpace( int location) {
		super('_', location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		return InteractionResult.NONE;
	}
		

}
