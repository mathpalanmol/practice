package game.card;

public class Card implements Comparable<Card> {
	int rank; // 1 to 13
	int suit; // 1 to 4

	public Card(int rank, int suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}

	@Override
	public String toString() {
		String str = "";
		String[] suits = { "", "CLUB", "HEART", "DIAMOND", "SPADE" };
		str = rank + " of " + suits[suit];
		return str;
	}

	@Override
	public int compareTo(Card card) {
		int ccRank = this.rank;
		int ocRank = card.getRank();
		ccRank = ccRank == 1 ? 14 : ccRank;
		ocRank = ocRank == 1 ? 14 : ocRank;
		return ccRank - ocRank;

	}

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}

	public static void main(String[] args) {
		Card c = new Card(1, 1);
		System.out.println(c);
	}

}
