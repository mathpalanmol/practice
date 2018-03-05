package game.card;

import java.util.ArrayList;

public class Game {
	Player winner;

	public void play() {
		CardDeck deck = new CardDeck();
		Player player1 = new Player("Ashok");
		Player player2 = new Player("Amit");
		for (int i = 0; i < 26; i++) {
			player1.getPlayPile().addCard(deck.deal());
			player2.getPlayPile().addCard(deck.deal());
		}
		// todoprint the pile
		outer: while (true) {
			Card cp1 = player1.nextCard();
			Card cp2 = player2.nextCard();
			if (cp1 == null)
				winner = player2;
			if (cp2 == null)
				winner = player1;
			if (cp1.compareTo(cp2) > 1) {
				player1.collectCard(cp1);
				player1.collectCard(cp2);
			} else if ((cp1.compareTo(cp2) < 1)) {
				player2.collectCard(cp1);
				player2.collectCard(cp2);
			} else {

				ArrayList<Card> cardsp1 = new ArrayList<Card>();
				ArrayList<Card> cardsp2 = new ArrayList<Card>();// place holder for down cards.
				while (true) {
					int count = cp1.rank;// both card rank are equal.
					if (player1.totalCardsLeft() < count) {
						winner = player2;
						break outer;
					}
					if (player2.totalCardsLeft() < count) {
						winner = player1;
						break outer;
					}
					if (player1.playPileCardCount() < count) {
						int temp = count;
						pileDownCards(cardsp1, temp, player1);
						temp = temp - player1.playPileCardCount();
						pileDownCards(cardsp1, temp, player1);

					}
					if (player2.playPileCardCount() < count) {
						int temp = count;
						pileDownCards(cardsp2, temp, player2);
						temp = temp - player2.playPileCardCount();
						pileDownCards(cardsp2, temp, player2);
					}
					cp1 = cardsp1.get(count - 1);
					cp2 = cardsp2.get(count - 1);
					if (cp1 == cp2) {// comparelast downcard
						continue;
					} else {
						if (cp1.compareTo(cp2) > 1) {
							player1.collectCard(cp1);// todo can be extra
							for (Card dCard : cardsp1)
								player1.collectCard(dCard);
							player1.collectCard(cp2);
							for (Card dCard : cardsp2)
								player1.collectCard(dCard);
						} else if ((cp1.compareTo(cp2) < 1)) {
							player2.collectCard(cp1);
							for (Card dCard : cardsp1)
								player1.collectCard(dCard);
							player2.collectCard(cp2);
							for (Card dCard : cardsp2)
								player1.collectCard(dCard);
						}
						cardsp1.clear();
						cardsp2.clear();
						break;
					}
				}
			}

		}

	}

	// starting point... we can make one more class and put this code there.
	public static void main(String[] args) {
		Game game = new Game();
		game.play();
		System.out.println(game.getWinner().getName());
	}

	private void pileDownCards(ArrayList<Card> downPile, int temp, Player player) {
		for (int i = 0; i < temp; i++) {
			downPile.add(player.nextCard());
		}
	}

	public Player getWinner() {
		return winner;
	}

}
