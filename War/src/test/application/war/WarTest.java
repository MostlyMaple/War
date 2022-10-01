package test.application.war;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.war.War;
import application.war.WarClassic;
import application.war.WarStoreDeck;

class WarTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testClassicWar() {
		War warGame = new WarClassic(100, 1);
		try {
			warGame.runGame();
		} catch (Exception e) {
			fail("An error occured in the game");
		}	
	}
	
	@Test
	void testStoredWarTwoPlayer() {
		War warGame;
		try {
			warGame = new WarStoreDeck(2, 1);
			warGame.runGame();
		} catch (Exception e1) {
			e1.printStackTrace();
			fail("An error occured in the game");
		}
	}
	
	@Test
	void testStoredWarThreePlayer() {
		War warGame;
		try {
			warGame = new WarStoreDeck(3, 1);
			warGame.runGame();
		} catch (Exception e1) {
			e1.printStackTrace();
			fail("An error occured in the game");
		}
	}
	
}
