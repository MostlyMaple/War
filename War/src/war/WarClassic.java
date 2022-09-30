package war;

import java.util.ArrayList;

import application.players.PlayerClassic;
import cardGame.Card;
import cardGame.DeckOfCards;

public class WarClassic implements War {
	
	private final int END_GAME = -1;
	int numPlayers = 2;
	int roundCount;
	PlayerClassic players[];
	int seed;
	DeckOfCards originalDeck;
	
	public WarClassic(int roundCount, int seed) {
		players = new PlayerClassic[numPlayers];
		this.seed = seed;
		this.originalDeck = new DeckOfCards(true, seed);
		this.roundCount = roundCount;
		for (int i = 0; i < numPlayers; i++) {
			players[i] = new PlayerClassic();
		}
	}
	
	public void runGame() {
		dealCards(originalDeck, numPlayers, players);
		for (int i = 0; i < roundCount; i++) {
			if (drawForWar(numPlayers, players) == END_GAME)
				break;
			showScore();
		}
		printGameWinner();	
	}
	
	public void giveWinnerCards(int winner, Card[] drawnCards, ArrayList<Card> faceDownCards) {
		for (int i = 0; i < numPlayers; i++) {
			players[winner].addCardToHand(players[winner].getCardsInHand(), drawnCards[i]);
		}
		while (!faceDownCards.isEmpty()) {
			players[winner].addCardToHand(players[winner].getCardsInHand(),faceDownCards.remove(faceDownCards.size()-1));
		}
	}
	
	public void showScore() {
		for (int j = 0; j < numPlayers; j++) {
			System.out.println("Player " + (j + 1) + " has a score of " + players[j].getHandCardCount(players[j].getCardsInHand()));
		}
		System.out.println();
	}
	
	public int getWinner() {
		int winner = 0;
		for (int i = 1; i < numPlayers; i++) {
			int currentWinnerScore = players[winner].getHandCardCount(players[winner].getCardsInHand());
			int checkIfWinnerScore = players[i].getHandCardCount(players[i].getCardsInHand());
			if (currentWinnerScore <  checkIfWinnerScore) {
				winner = i;
			} else if (currentWinnerScore == checkIfWinnerScore) {
				return -1;
			}
		}
		return winner + 1;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
