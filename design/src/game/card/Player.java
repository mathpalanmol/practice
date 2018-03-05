package game.card;

public class Player {

	String name;
	Pile playPile;
	Pile wonPile;

	public Player(String name) {
		this.name = name;
		playPile = new Pile();
		wonPile = new Pile();
	}

	public Card nextCard() {
		if (playPile.isEmpty()) {
			if (!wonPile.isEmpty()) {
				playPile = wonPile;
			} else {
				return null;
			}
		}
		Card next = playPile.getCards().get(0);
		playPile.removeCard(next);
		return next;
	}
	
	public void collectCard(Card card) {
		wonPile.addCard(card);
	}
	
	public Pile getPlayPile() {
		return playPile;
	}

	public void setPlayPile(Pile playPile) {
		this.playPile = playPile;
	}

	public Pile getWonPile() {
		return wonPile;
	}

	public void setWonPile(Pile wonPile) {
		this.wonPile = wonPile;
	}

	public int totalCardsLeft() {
		return (playPile.getSize() + wonPile.getSize());
	}
	
	public int playPileCardCount() {
		return playPile.getSize();
	}
	public int wonPileCardCount() {
		return wonPile.getSize();
	}

	public String getName() {
		return name;
	}

}
