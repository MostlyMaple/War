package application.players;

import application.cardGame.Card;

public interface StorablePlayer extends Player {
	
	void addCardToKeepPile(Card newCard);
	
	int getKeepPileCount();
}
