package test.application.player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.cardGame.Card;
import application.cardGame.DeckOfCards;
import application.players.Player;
import application.players.PlayerClassic;

class PlayerTest {

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
	void testPlayerHandEmpty() {
		Player player = new PlayerClassic();
		DeckOfCards empty = new DeckOfCards();
		empty.setDeckEmpty(false);
		player.setCardsInHand(empty);
		assertFalse(player.isHandEmpty(player.getCardsInHand()));
	}
	
	@Test
	void testAddCard() {
		Player player = new PlayerClassic();
		DeckOfCards empty = new DeckOfCards();
		empty.setDeckEmpty(false);
		player.setCardsInHand(empty);
		Card newCard = new Card(1, 2);
		player.addCardToHand(player.getCardsInHand(), newCard);
		assertEquals(player.getCardsInHand().getBottomCard().getCardValue(), 2);
	}
	
	@Test
	void testGetCard() {
		Player player = new PlayerClassic();
		DeckOfCards empty = new DeckOfCards();
		empty.setDeckEmpty(false);
		player.setCardsInHand(empty);
		Card newCard = new Card(1, 9);
		player.addCardToHand(player.getCardsInHand(), newCard);
		assertEquals(player.drawCard(player.getCardsInHand()).getCardValue(), 9);
	}
}
