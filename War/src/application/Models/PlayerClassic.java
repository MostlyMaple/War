package application.Models;

public class PlayerClassic implements Player{
	
	DeckOfCards cardsInHand;
	
	public PlayerClassic() {
		
	}
	
	public DeckOfCards getCardsInHand() {
		return cardsInHand;
	}

	public void setCardsInHand(DeckOfCards cardsInHand) {
		this.cardsInHand = cardsInHand;
	}

}

