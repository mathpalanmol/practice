package game.card;

import java.util.ArrayList;

public class Pile {
	ArrayList<Card> cards;
	public Pile() {
		cards = new ArrayList<Card>();
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public void addCards(Pile pile) {
		ArrayList<Card> cards = pile.getCards();
		for (Card card : cards) {
			this.cards.add(card);
		}
	}

	public void removeCard(Card card) {
		if (cards.contains(card)) {
			cards.remove(card);
		}
	}
	
	public ArrayList<Card> getCards() {
		return this.cards;
	}

	public boolean isEmpty() {
		  return cards.isEmpty();
	}
	
	public int getSize() {
		return cards.size();
	}
	

}
