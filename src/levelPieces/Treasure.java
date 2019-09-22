/**
 * @author Robert Warner
 * @author Jo Westrap
 */

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
	//Awards player a point for landing on it. Deletes it self after award is given
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (super.getLocation() == playerLocation) {
			pieces[this.getLocation()] = null;
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
		
	}

}
