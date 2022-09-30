package war;

import java.util.ArrayList;

import application.players.PlayerStoreDeck;
import cardGame.Card;
import cardGame.DeckOfCards;

public class WarStoreDeck implements War {
	
	int numPlayers;
	PlayerStoreDeck players[];
	int seed;
	DeckOfCards originalDeck;
	
	public WarStoreDeck(int numPlayers, int seed) {
		this.numPlayers = numPlayers;
		this.players = new PlayerStoreDeck[numPlayers];
		this.seed = seed;
		this.originalDeck = new DeckOfCards(true, seed);
		for (int i = 0; i < numPlayers; i++) {
			this.players[i] = new PlayerStoreDeck();
		}
	}
	
	public void runGame() {
		dealCards(originalDeck, numPlayers, players);
		while (true) {
			if (drawForWar(numPlayers, players) == -1)
				break;
			showScore();
		}
		printGameWinner();
	}
	
	public void giveWinnerCards(int winner, Card[] drawnCards, ArrayList<Card> faceDownCards) {
		for (int i = 0; i < numPlayers; i++) {
			players[winner].addCardToKeepPile(drawnCards[i]);
		}
		while (!faceDownCards.isEmpty()) {
			players[winner].addCardToKeepPile(faceDownCards.remove(faceDownCards.size()-1));
		}
	}
	
	public void showScore() {
		for (int j = 0; j < numPlayers; j++) {
			System.out.println("Player " + (j + 1) + " has a score of " + players[j].getKeepPileCount());
		}
		System.out.println();
	}
	
	public int getWinner() {
		int winner = 0;
		for (int i = 1; i < numPlayers; i++) {
			int currentWinnerScore = players[winner].getKeepPileCount();
			int checkIfWinnerScore = players[i].getKeepPileCount();
			if (currentWinnerScore <  checkIfWinnerScore) {
				winner = i;
			} else if (currentWinnerScore == checkIfWinnerScore) {
				return -1;
			}
		}
		return winner + 1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
