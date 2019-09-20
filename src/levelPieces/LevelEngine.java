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
	private ArrayList<Moveable> moveablePieces;
	private ArrayList<GamePiece> interactingPieces;


	public LevelEngine() {
		super();
		this.levelLength = GameEngine.BOARD_SIZE;
		this.numLevels = GameEngine.NUM_LEVELS;
		this.currentLevel = 0;
		moveablePieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>(0);
		
		
	}
	
	private Drawable[] makeBlankLevel() {
		this.level = new Drawable[levelLength];
		return level;
	}
	
	private Drawable[] level1() {
		this.level = makeBlankLevel();
		interactingPieces.clear();
		moveablePieces.clear();
		
		this.level[5] = new Flower();
		interactingPieces.add(new River(8));
		interactingPieces.add(new Treasure(12));
		interactingPieces.add(new Portal(20));
		Ghost ghost = new Ghost(18);
		moveablePieces.add(ghost);
		interactingPieces.add(ghost);
		
				
		for(GamePiece interactingPiece : interactingPieces) {
			this.level[interactingPiece.getLocation()] = interactingPiece;
		}

		
		
		return level;
		
	}
	
	private Drawable[] level2() {
		Drawable[] level = makeBlankLevel();
		interactingPieces.clear();
		moveablePieces.clear();
		
		interactingPieces.add(new River(10));
		interactingPieces.add(new River(12));
		interactingPieces.add(new River(14));
		interactingPieces.add(new River(16));
		interactingPieces.add(new River(18));
		interactingPieces.add(new Treasure(20));
		

		
		Ghost ghost = new Ghost(6);
		moveablePieces.add(ghost);
		interactingPieces.add(ghost);
	
		
		Ninja  ninja = new Ninja(19);
		moveablePieces.add(ninja);
		interactingPieces.add(ninja);

		
		for(GamePiece interactingPiece : interactingPieces) {
			this.level[interactingPiece.getLocation()] = interactingPiece;
		}
		
		
		return level;
		
	}
	

	public void createLevel(int levelNum) {
		this.level = null;
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
		
		return (moveablePieces);
	}
	public ArrayList<GamePiece> getInteractingPieces(){
		return interactingPieces;
		
	}

	public Drawable[] getBoard() {
		
		return this.level;
	}

	public int getPlayerStartLoc() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
