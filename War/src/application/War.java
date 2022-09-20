package application;

import application.Models.Card;
import application.Models.DeckOfCards;
import application.Models.Player;

public class War {
	
	private final boolean SHUFFLED = true;
	
	DeckOfCards originalDeck = new DeckOfCards(SHUFFLED);
	int numPlayers;
	Player players[];
	
	public War(int numPlayers) {
		this.numPlayers = numPlayers;
		this.players = new Player[numPlayers];
	}
	
	public void dealCards() {
		System.out.println("Dealing Cards\n");
		DeckOfCards[] dealtHands = originalDeck.splitDeck(3);
		
		for (int i = 0; i < numPlayers; i++) {
			players[i].setCardsInHand(dealtHands[i].getDeck());
			System.out.println(players[i].deckToString() + "\n");
		}
		}
	
//	public boolean drawForWar() {
//		Card player1Card;
//		Card player2Card;
//		int pointDifference = 0;
//		if (!player1Cards.isDeckEmpty() && !player2Cards.isDeckEmpty()) {
//			player1Card = player1Cards.getTopCard();
//			player2Card = player2Cards.getTopCard();
//			pointDifference = player1Card.getCardValue() - player2Card.getCardValue();
//			return true;
//		} 
//		return false;	
//	}
	
}
