package application.Models;

public interface StorablePlayer extends Player {
	
	void addCardToKeepPile(Card newCard);
	
	int getKeepPileCount();
}
