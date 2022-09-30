package war;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import application.players.Player;
import cardGame.Card;
import cardGame.DeckOfCards;

public interface War {
	final int END_GAME = -1;
	
	public default void dealCards(DeckOfCards originalDeck, int numPlayers, Player[] players) {
		System.out.println("Dealing Cards\n");
		DeckOfCards[] dealtHands = originalDeck.splitDeck(numPlayers);
		for (int i = 0; i < numPlayers; i++) {
			players[i].setCardsInHand(dealtHands[i]);
		}
	}
	
	public default boolean checkForWar(Card[] drawnCards) {
		Set<Integer> cardValues = new HashSet<>();
        for (Card curCard : drawnCards) {
            if (cardValues.add(curCard.getCardValue()) == false) {
                System.out.println("***WAR!***");
                return true;
            }
        }
        return false;
	}
	
	public default int calculateHighCard(Card[] drawnCards, int numPlayers) {
		Card currentHighestCard = drawnCards[0];
		int highestCardIndex = 0;
		for (int i = 0; i < numPlayers; i++) {
			if (drawnCards[i].getCardValue() > currentHighestCard.getCardValue()) {
				currentHighestCard = drawnCards[i];
				highestCardIndex = i;
			}
		}
		return highestCardIndex;
	}

	public default int drawForWar(int numPlayers, Player[] players) {
		ArrayList<Card> faceDownCards = new ArrayList<Card>();
		Card[] drawnCards;
		int roundWinner;
		
		if (checkForEmptyHands(numPlayers, players))
			return END_GAME;
		
		drawnCards = drawCards(numPlayers, players);
		
		if (checkForWar(drawnCards)) {
			storeThreeCards(faceDownCards, numPlayers, players);
			roundWinner = drawForWar(numPlayers, players);
			giveWinnerCards(roundWinner, drawnCards, faceDownCards);
			return roundWinner;
		}
		
		roundWinner = calculateHighCard(drawnCards, numPlayers);
		printRoundWinner(roundWinner);
		giveWinnerCards(roundWinner, drawnCards, faceDownCards);
		return roundWinner;
	}
	
	public default boolean checkForEmptyHands(int numPlayers, Player[] players) {
		for (int i = 0; i < numPlayers; i++) {
			if (players[i].getHandCardCount(players[i].getCardsInHand()) <= 0) {
				return true;
			}
		}
		return false;
	}
	
	public default void storeThreeCards(ArrayList<Card> faceDownCards, int numPlayers, Player[] players) {
		for (int i = 0; i < numPlayers; i++) {
			for (int j = 0; j < 3; j++) {
				faceDownCards.add(players[i].drawCard(players[i].getCardsInHand()));
			}
		}
	}
	
	public default void printRoundWinner(int winner) {
		System.out.println("Player " + (winner + 1) + " wins the round!\n");
	}
	
	public default Card[] drawCards(int numPlayers, Player[] players) {
		Card[] drawnCards = new Card[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			drawnCards[i] = players[i].drawCard(players[i].getCardsInHand());
			System.out.println("Player " + (i + 1) + " plays " + drawnCards[i].toString());
		}
		return drawnCards;
	}
	
	public default void printGameWinner() {
		if (getWinner() == -1) {
			System.out.println("There is a tie");
		} else {
			System.out.println("Player " + getWinner() + " wins!");
		}
	}
	
	void runGame();
	void giveWinnerCards(int winner, Card[] drawnCards, ArrayList<Card> faceDownCards);
	void showScore();
	int getWinner();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
