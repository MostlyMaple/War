package application.players;

import application.cardGame.Card;
import application.cardGame.DeckOfCards;

public class PlayerStoreDeck implements StorablePlayer {
	
	DeckOfCards cardsWon;
	DeckOfCards cardsInHand;
	
	public PlayerStoreDeck() {
		this.cardsWon = new DeckOfCards();
	}
	
	public DeckOfCards getCardsInHand() {
		return cardsInHand;
	}

	public void setCardsInHand(DeckOfCards cardsInHand) {
		this.cardsInHand = cardsInHand;
	}
	
	public void addCardToKeepPile(Card newCard) {
		this.cardsWon.addCardToBottom(newCard);
	}
	
	public int getKeepPileCount() {
		return cardsWon.getCardCount();
	}

	
}
