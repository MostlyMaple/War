package application.Models;

public class PlayerStoreDeck extends Player implements StorablePlayer{
	
	DeckOfCards cardsWon;
	DeckOfCards cardsInHand;
	
	public PlayerStoreDeck() {
		super();
		this.cardsWon = new DeckOfCards();
	}
	
	public void addCardToKeepPile(Card newCard) {
		this.cardsWon.addCardToBottom(newCard);
	}
	
	public int getKeepPileCount() {
		return cardsWon.getCardCount();
	}
	
}
