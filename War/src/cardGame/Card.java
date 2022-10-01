package cardGame;

public class Card {
	private int suit;
	private int value;
	
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
			cardPrint = cardPrint + "JACK";
		} else if (this.value == 12) {
			cardPrint = cardPrint + "QUEEN";
		} else if (this.value == 13) {
			cardPrint = cardPrint + "KING";
		} else if (this.value == 1) {
			cardPrint = cardPrint + "ACE";
		} else {
			cardPrint = cardPrint + this.value;
		}
		return cardPrint;
	}
	
	public String printSuit() {
		String cardPrint = "";
		switch (this.suit) {
		case 0:
			cardPrint = cardPrint + " of HEARTS";
			break;
		case 1:
			cardPrint = cardPrint + " of DIAMONDS";
			break;
		case 2:
			cardPrint = cardPrint + " of SPADES";
			break;
		case 3:
			cardPrint = cardPrint + " of CLUBS";
			break;
		default:
			System.err.println("Incorrect Suit Value");
			System.exit(0);
		}
		return cardPrint;
	}
	

	public int getCardValue() {
		if (this.value == 1) {
			return 14;
		} else {
			return this.value;
		}
	}
	
	public int getCardSuit() {
		return suit;
	}
}
