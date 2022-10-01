package application.players;

import application.cardGame.Card;
import application.cardGame.DeckOfCards;

public interface Player {
	
	public default Card drawCard(DeckOfCards cardsInHand) {
		Card drawnCard; 
		if (hasCardLeft(cardsInHand)) {
			drawnCard = cardsInHand.getTopCard();
			return drawnCard;
		}
		return null;
	}
	
	public default boolean hasCardLeft(DeckOfCards cardsInHand) {
		if (cardsInHand.getCardCount() > 0) {
			return true;
		}
		return false;
	}

	public default DeckOfCards getCardsInHand(DeckOfCards cardsInHand) {
		return cardsInHand;
	}

	public default String handToString(DeckOfCards cardsInHand) {
		return cardsInHand.toString();
	}
	
	public default boolean isHandEmpty(DeckOfCards cardsInHand) {
		return cardsInHand.isDeckEmpty();
	}
	
	public default void addCardToHand(DeckOfCards cardsInHand, Card newCard) {
		cardsInHand.addCardToBottom(newCard);
	}
	
	public default int getHandCardCount(DeckOfCards cardsInHand) {
		return cardsInHand.getCardCount();
	}
	
	DeckOfCards getCardsInHand();
	
	void setCardsInHand(DeckOfCards cardsInHand);
}
