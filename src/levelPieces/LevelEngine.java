package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import gameEngine.Player;

public class LevelEngine {
	
	private int levelLength;
	private int numLevels;
	private int currentLevel;
	private Drawable[] level;


	public LevelEngine() {
		super();
		this.levelLength = GameEngine.BOARD_SIZE;
		this.numLevels = GameEngine.NUM_LEVELS;
		this.currentLevel = 0;
		
		
		
	}
	
	private Drawable[] makeBlankLevel() {
		Drawable[] level = new GamePiece[levelLength];
		for (int i = 0; i < this.levelLength; i++) {
			level[i] = new BlankSpace(i);			
		}
		return level;
	}
	
	private Drawable[] level1() {
		Drawable[] level = makeBlankLevel();
		level[10] = new River(10);
		level[20] = new Treasure(20);
		level[0] = new Player(0);
		return level;
		
	}
	
	private Drawable[] level2() {
		Drawable[] level = makeBlankLevel();
		level[10] = new River(10);
		level[12] = new River(12);
		level[14] = new River(14);
		level[16] = new River(16);
		level[18] = new River(18);
		level[20] = new Treasure(20);
		level[0] = new Player(0);
		return level;
		
	}
	

	public void createLevel(int levelNum) {
		switch(levelNum) {
		case 1:
			this.level = level1();
			break;
		case 2:
			this.level = level2();
			break;
		default:
			this.level = makeBlankLevel();
			break;
		}
		
	}

	public ArrayList<Moveable> getMovingPieces() {
		
		return null;
	}
	public ArrayList<GamePiece> getInteractingPieces(){
		
	}

	public Drawable[] getBoard() {
		
		return this.level;
	}

	public int getPlayerStartLoc() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
