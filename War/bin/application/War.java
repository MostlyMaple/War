package application;

import java.util.HashSet;
import java.util.Set;

import application.Models.Card;
import application.Models.DeckOfCards;
import application.Models.Player;

public abstract class War {
	
	int numPlayers;
	int seed;
	DeckOfCards originalDeck;
	
	Player players[];
	
	public void dealCards() {
		System.out.println("Dealing Cards\n");
		DeckOfCards[] dealtHands = originalDeck.splitDeck(numPlayers);
		for (int i = 0; i < numPlayers; i++) {
			players[i].setCardsInHand(dealtHands[i]);
		}
	}
	
	public int checkForWar(Card[] drawnCards) {
		Set<Integer> cardValues = new HashSet<>();
        for (Card curCard : drawnCards) {
            if (cardValues.add(curCard.getCardValue()) == false) {
                System.out.println("***WAR!***");
                return 1;
            }
        }
        return 0;
	}
	
	public int calculateHighCard(Card[] drawnCards) {
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


	protected abstract void runGame();
	
	protected abstract int drawForWar();

	protected abstract void showScore();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
