package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class BlankSpace implements Drawable {

	private int location;
	private char symbol = ' ';
	
	
	public BlankSpace(int location) {
		this.location = location; 
	}
	
	@Override
	public void draw() {
		System.out.print(this.symbol);
		
	}

		

}
