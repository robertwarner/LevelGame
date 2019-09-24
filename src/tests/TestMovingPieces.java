package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.*;

public class TestMovingPieces {

	@Test
	public void ghostMovingTest() {
		Ghost ghost = new Ghost(0);
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		gameBoard[5] = new River(5);
		gameBoard[10] = new River(10);
		
		for(int i = 0; i < GameEngine.BOARD_SIZE + 3; i++) {
			// ghost should skip over occupied spaces, 
			// 	and wrap around if it goes past the end of the array
			System.out.println(i);
			if (i < 5)
				assertEquals(ghost.getLocation(), i);
			else if (i >= 5 && i < 9)
				assertEquals(ghost.getLocation(), i+1);
			else if (i >= 9 && i < GameEngine.BOARD_SIZE + 3)
				assertEquals(ghost.getLocation(), (i+2) % GameEngine.BOARD_SIZE);
			ghost.move(gameBoard, -1);
		}
	}

}
