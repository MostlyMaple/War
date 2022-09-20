package application.Models;

import java.util.ArrayList;

public class Player {
	ArrayList<Card> cardsInHand = new ArrayList<Card>();
	
	
	public void addCard(Card newCard) {
		cardsInHand.add(newCard);
	}
	
	public Card drawCard() {
		Card drawnCard; 
		if (hasCardLeft()) {
			drawnCard = cardsInHand.get(cardsInHand.size());
			cardsInHand.remove(cardsInHand.size());
			return drawnCard;
		}
		return null;
	}
	
	public boolean hasCardLeft() {
		if (cardsInHand.size() > 0) {
			return true;
		}
		return false;
	}

	public ArrayList<Card> getCardsInHand() {
		return cardsInHand;
	}

	public void setCardsInHand(ArrayList<Card> cardsInHand) {
		this.cardsInHand = cardsInHand;
	}
	
	public String deckToString() {
		String deckPrint = "";
		for (int i = 0; i < cardsInHand.size(); i++) {
			deckPrint = deckPrint + cardsInHand.get(i).toString();
		}
		return deckPrint;
	}
}
