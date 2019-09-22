/**
 * @author Robert Warner
 * @author Jo Westrap
 * 
 * 
 * This piece only implements Drawable, not a GamePiece
 * 
 * 
 */

package levelPieces;

import gameEngine.Drawable;

public class Flower implements Drawable {
	//Piece gets deleted if player lands on it! Like a flower being trampled on
	
	@Override
	public void draw() {
		
		System.out.print('F');
	}

}
