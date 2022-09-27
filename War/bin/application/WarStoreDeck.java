package application;

import java.util.ArrayList;
import application.Models.Card;
import application.Models.DeckOfCards;
import application.Models.PlayerStoreDeck;

public class WarStoreDeck extends War {
	
	public WarStoreDeck(int numPlayers, int seed) {
		super.numPlayers = numPlayers;
		super.players = new PlayerStoreDeck[numPlayers];
		super.seed = seed;
		super.originalDeck = new DeckOfCards(true, seed);
		for (int i = 0; i < numPlayers; i++) {
			super.players[i] = new PlayerStoreDeck();
		}
	}
	
	public void runGame() {
		dealCards();
		for (int i = 0; i < 10000; i++) {
			if (drawForWar() == -1)
				break;
			showScore();
		}
	}
	
	public int drawForWar() {
		int winner;
		ArrayList<Card> faceDownCards = new ArrayList<Card>();
		
		for (int i = 0; i < numPlayers; i++) {
			if (players[i].getHandCardCount() <= 0) {
				System.out.println("Player " + i + " has run out of cards");
				return -1;
			}
		}
		
		Card[] drawnCards = new Card[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			drawnCards[i] = players[i].drawCard();
			System.out.println("Player " + i + " plays " + drawnCards[i].toString());
		}
		
		if (checkForWar(drawnCards) == 1) {
			for (int i = 0; i < numPlayers; i++) {
				for (int j = 0; j < 3; j++) {
					faceDownCards.add(players[i].drawCard());
				}
			}
			winner = drawForWar();
			if (winner == -1) {
				return -1;
			}
		} else {
			winner = calculateHighCard(drawnCards);
			System.out.println("Player " + winner + " wins the round!\n");
			for (int i = 0; i < numPlayers; i++) {
				players[winner].addCardToKeepPile(drawnCards[i]);
			}
			return winner;
		}
		
		for (int i = 0; i < numPlayers; i++) {
			players[winner].addCardToKeepPile(drawnCards[i]);
		}
		
		while (!faceDownCards.isEmpty()) {
			players[winner].addCardToKeepPile(faceDownCards.remove(faceDownCards.size()-1));
		}
		
		return winner;
		
	}
	
	public void showScore() {
		for (int j = 0; j < numPlayers; j++) {
			System.out.println("Player " + j + " has a score of " + players[j].getKeepPileCount());
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
