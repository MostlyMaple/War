package application.Models;

public interface StorablePlayer {
	
	public void addCardToKeepPile(Card newCard);
	
	public int getKeepPileCount();
}
