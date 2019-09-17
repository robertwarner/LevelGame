package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelEngine {
	
	private int levelLength;
	private GamePiece[] level;

	public LevelEngine() {
		super();
		this.levelLength = 5;
		this.level = new GamePiece[levelLength];
		
	}

	public void createLevel(int levelNum) {
		switch(levelNum) {
		case 0:
			this.level = []
		}
		
		
	}

	public ArrayList<Moveable> getMovingPieces() {
		
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<GamePiece> getInteractingPieces(){
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
