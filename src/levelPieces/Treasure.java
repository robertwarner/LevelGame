package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Treasure extends GamePiece {

	public Treasure(char symbol, int location) {
		super(symbol, location);
	}
	public Treasure(int location) {
		super('T', location);
	}


	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		
		return InteractionResult.GET_POINT;
	}

}
