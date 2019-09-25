/*
 * @author Robert Warner
 * @author Josephine Westarp
 */

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

		for (int i = 0; i < GameEngine.BOARD_SIZE + 3; i++) {
			// Ghost should skip over occupied spaces,
			// and wrap around if it goes past the end of the array.
			if (i < 5)
				assertEquals(ghost.getLocation(), i);
			else if (i >= 5 && i < 9)
				assertEquals(ghost.getLocation(), i + 1);
			else if (i >= 9 && i < GameEngine.BOARD_SIZE + 3)
				assertEquals(ghost.getLocation(), (i + 2)
						% GameEngine.BOARD_SIZE);
			ghost.move(gameBoard, -1);
		}
	}

	@Test
	public void ninjaMovingTest() {
		Ninja ninja = new Ninja(0);
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		boolean[] forbiddenSpaces = new boolean[GameEngine.BOARD_SIZE];

		// fill up most of the board with unmoving pieces
		forbiddenSpaces[0] = true;
		for (int i = 1; i < GameEngine.BOARD_SIZE; i++) {
			if (GameEngine.BOARD_SIZE % i != 0) {
				gameBoard[i] = new River(i);
				forbiddenSpaces[i] = false;
			} else {
				forbiddenSpaces[i] = true;
			}
		}

		// Move the Ninja a whole lot and it should never land on
		// an occupied space.
		for (int i = 0; i < 10000; i++) {
			ninja.move(gameBoard, 0);
			assertTrue(forbiddenSpaces[ninja.getLocation()]);
		}
	}

}
