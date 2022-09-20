package application.Models;
import java.util.ArrayList;
import java.util.Random;


public class DeckOfCards {
	private final int CARDCOUNT = 52;
	ArrayList<Card> deck;
	boolean deckEmpty;
	
	public DeckOfCards() {
		deck = new ArrayList<Card>();
		deckEmpty = true;
	}

	public DeckOfCards(boolean shuffled) {
		deck = new ArrayList<Card>();
		this.createCards();
		if (shuffled) {
			shuffleDeck();
		}
	}
	
	public void createCards() {
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 13; j++) {
				Card newCard = new Card(i,j);
				deck.add(newCard);
			}
		}
	}
	
	public void shuffleDeck() {
		Random rand = new Random();
		Card removedCard;
		ArrayList<Card> shuffledCardStack = new ArrayList<Card>();
		int sizeOfStack;
		for(int i = 0; i < CARDCOUNT; i++) {
			sizeOfStack = deck.size();
			removedCard = deck.remove(rand.nextInt(sizeOfStack));
			shuffledCardStack.add(removedCard);
		}
		setDeckEmpty(false);
		deck = shuffledCardStack;
	}
	
	public DeckOfCards[] splitDeck(int numPlayers) {
		DeckOfCards playerDecks[] = new DeckOfCards[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			playerDecks[i] = new DeckOfCards();
		}
		int currentHand = 0;
		Card currentCard;
		while (deck.isEmpty() == false) {
			currentCard = getTopCard();
			(playerDecks[currentHand].deck).add(currentCard);
			currentHand = (currentHand + 1) % numPlayers;
		}
		
		return playerDecks;	
	}
	
	
	public String toString() {
		String deckPrint = "";
		for (int i = 0; i < CARDCOUNT; i++) {
			deckPrint = deckPrint + deck.get(i).toString();
		}
		return deckPrint;
	}
	
	public Card getTopCard() {
		Card topCard = deck.remove(deck.size()-1);
		if (deck.isEmpty()) {
			setDeckEmpty(true);
		}
		return topCard;
	}
	
	public void setDeckEmpty(boolean deckEmpty) {
		this.deckEmpty = deckEmpty;
	}
	
	public boolean isDeckEmpty() {
		return deckEmpty;
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

}
