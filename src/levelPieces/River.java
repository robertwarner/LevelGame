package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class River extends GamePiece{
	
	public River(char symbol, int location) {
		super(symbol, location);
		
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		
		return InteractionResult.KILL;
	}
	
	

}
