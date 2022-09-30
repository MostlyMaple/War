package application.players;

import cardGame.Card;

public interface StorablePlayer extends Player {
	
	void addCardToKeepPile(Card newCard);
	
	int getKeepPileCount();
}
