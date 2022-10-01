package test.application.cardGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.cardGame.Card;
import application.cardGame.DeckOfCards;

class DeckOfCardsTest {

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
	void splitDeck2Ways() {
		DeckOfCards deck = new DeckOfCards(true, 1);
		DeckOfCards[] playerDecks;
		playerDecks = deck.splitDeck(2);
		assertEquals(playerDecks[0].getCardCount(), 26);
	}
	
	@Test
	void splitDeck3Ways() {
		DeckOfCards deck = new DeckOfCards(true, 1);
		DeckOfCards[] playerDecks;
		playerDecks = deck.splitDeck(3);
		assertEquals(playerDecks[0].getCardCount(), 17);
	}
	
	@Test
	void checkCardValue() {
		DeckOfCards deck = new DeckOfCards(false, 1);
		Card newCard = deck.getTopCard();
		assertEquals(newCard.getCardValue(), 13);
	}
	
	@Test
	void checkCardSuit() {
		DeckOfCards deck = new DeckOfCards(false, 1);
		Card newCard = deck.getTopCard();
		assertEquals(newCard.getCardSuit(), 3);
	}
	
}
