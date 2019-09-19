package levelPieces;

import gameEngine.Moveable;
import gameEngine.Drawable;
import java.util.Random;
import gameEngine.InteractionResult;


public class Ninja extends GamePiece implements Moveable {
	public Ninja(char symbol, int location) {
		super(symbol, location);
		
	}
	
	public Ninja(int location) {
		super('X', location);
		
	}
	

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == super.getLocation()) {
			return InteractionResult.KILL;
		}
		if(Math.abs(playerLocation - super.getLocation()) == 1) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
		
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		Random random = new Random();
		int nextLocation = random.nextInt(gameBoard.length);
		while (nextLocation == playerLocation) {
			nextLocation = random.nextInt(gameBoard.length);
		}
		this.setLocation(nextLocation);
	}

}
