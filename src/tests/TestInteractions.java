package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.*;

public class TestInteractions {

	@Test
	public void ghostInteractionTest() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Ghost ghost = new Ghost(10);
		gameBoard[10] = ghost;

		assertEquals(InteractionResult.KILL, ghost.interact(gameBoard, 10));

		for (int i = 0; i < 9; i++) {
			assertEquals(InteractionResult.NONE, ghost.interact(gameBoard, i));
		}
		for (int i = 12; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, ghost.interact(gameBoard, i));
		}

		assertEquals(InteractionResult.KILL, ghost.interact(gameBoard, 9));
		assertEquals(InteractionResult.KILL, ghost.interact(gameBoard, 11));

	}

	@Test
	public void ninjaInteractionTest() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Ninja ninja = new Ninja(10);
		gameBoard[10] = ninja;

		for (int i = 0; i < 7; i++)
			assertEquals(InteractionResult.NONE, ninja.interact(gameBoard, i));

		for (int i = 7; i < 14; i++) {
			if (i == 10)
				assertEquals(InteractionResult.KILL, ninja.interact(gameBoard, i));
			else
				assertEquals(InteractionResult.HIT, ninja.interact(gameBoard, i));
		}

		for (int i = 14; i < GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE, ninja.interact(gameBoard, i));

	}

	@Test
	public void riverInteractionTest() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		River river = new River(10);
		gameBoard[10] = river;

		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if (i == 10) {
				assertEquals(InteractionResult.KILL, river.interact(gameBoard, i));
			} else {
				assertEquals(InteractionResult.NONE, river.interact(gameBoard, i));
			}
		}
	}

	@Test
	public void portalInteractionTest() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Portal portal = new Portal(10);
		gameBoard[10] = portal;

		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if (i == 10) {
				assertEquals(InteractionResult.ADVANCE, portal.interact(gameBoard, i));
			} else {
				assertEquals(InteractionResult.NONE, portal.interact(gameBoard, i));
			}
		}
	}

	@Test
	public void treasureInteractionTest() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Treasure treasure = new Treasure(10);
		gameBoard[10] = treasure;

		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if (i == 10) {
				assertEquals(InteractionResult.GET_POINT, treasure.interact(gameBoard, i));
			} else {
				assertEquals(InteractionResult.NONE, treasure.interact(gameBoard, i));
			}
		}
		assertEquals(gameBoard[10], null); // Treasure deletes self from board when picked up
	}

}
