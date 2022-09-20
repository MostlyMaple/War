package application.Models;

public class Card {
	int suit;
	int value;
	
	public Card() {
		
	}
	
	public Card(int suit, int value) {
		this.suit = suit;
		this.value = value;
	}
	
	public String toString() {
		String cardPrint = "";
		cardPrint = cardPrint + printValue();
		cardPrint = cardPrint + printSuit();
		return cardPrint;
	}
	
	public String printValue() {
		String cardPrint = "";
		if (this.value == 11) {
			cardPrint = cardPrint + "Jack";
		} else if (this.value == 12) {
			cardPrint = cardPrint + "Queen";
		} else if (this.value == 13) {
			cardPrint = cardPrint + "King";
		} else if (this.value == 1) {
			cardPrint = cardPrint + "Ace";
		} else {
			cardPrint = cardPrint + this.value;
		}
		return cardPrint;
	}
	
	public String printSuit() {
		String cardPrint = "";
		switch (this.suit) {
		case 0:
			cardPrint = cardPrint + " of Hearts\n";
			break;
		case 1:
			cardPrint = cardPrint + " of Diamonds\n";
			break;
		case 2:
			cardPrint = cardPrint + " of Spades\n";
			break;
		case 3:
			cardPrint = cardPrint + " of Clubs\n";
			break;
		default:
			System.err.println("Incorrect Suit Value");
			System.exit(0);
		}
		return cardPrint;
	}
	

	public int getCardValue() {
		if (this.value >= 10) {
			return 10;
		} else {
			return this.value;
		}
	}
	
	public int getCardSuit() {
		return suit;
	}
}
