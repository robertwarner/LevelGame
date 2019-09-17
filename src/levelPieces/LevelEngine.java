package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelEngine {
	
	private int levelLength;
	private char[] level;

	public LevelEngine() {
		super();
		this.levelLength = 15;
		this.level = new char[levelLength];
		
	}

	public void createLevel(int levelNum) {
		
		
	}

	public ArrayList<GamePiece> getMovingPieces() {
		// TODO Auto-generated method stub
		return null;
	}

	public Drawable[] getBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getPlayerStartLoc() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
