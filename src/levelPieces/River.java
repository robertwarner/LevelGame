package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class River extends GamePiece{
	
	public River(char symbol, int location) {
		super(symbol, location);
		
	}
	public River(int location) {
		super('_', location);
		
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (super.getLocation() == playerLocation) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}
	
	

}
