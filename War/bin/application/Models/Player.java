package application.Models;

public abstract class Player {
	
	DeckOfCards cardsInHand;
	
	public Card drawCard() {
		Card drawnCard; 
		if (hasCardLeft()) {
			drawnCard = cardsInHand.getTopCard();
			return drawnCard;
		}
		return null;
	}
	
	public boolean hasCardLeft() {
		if (cardsInHand.getCardCount() > 0) {
			return true;
		}
		return false;
	}

	public DeckOfCards getCardsInHand() {
		return cardsInHand;
	}

	public void setCardsInHand(DeckOfCards cardsInHand) {
		this.cardsInHand = cardsInHand;
	}
	
	public String handToString() {
		return cardsInHand.toString();
	}
	
	public boolean isHandEmpty() {
		return cardsInHand.isDeckEmpty();
	}
	
	public void addCardToHand(Card newCard) {
		this.cardsInHand.addCardToBottom(newCard);
	}
	
	public int getHandCardCount() {
		return cardsInHand.getCardCount();
	}
	
	public abstract void addCardToKeepPile(Card newCard);
	
	public abstract int getKeepPileCount();
}
