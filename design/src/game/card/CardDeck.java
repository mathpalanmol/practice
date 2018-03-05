package game.card;

import java.util.Random;

public class CardDeck {
	private Card[] deck;
	int front;
	int end;

	public CardDeck() {
		deck = new Card[52];
		fill();
	}

	private void fill() {
		int counter = 0;
		for (int i = 1; i <= 13; i++) {
			for (int j = 1; j <= 4; j++) {
				Card card = new Card(i, j);
				deck[counter++] = card;
			}
		}
		end = 51;

	}

	public Card deal() {
		if (end < 0)
			return null;
		return deck[end--];
	}

	public void suffle() {
		for (int i = 0; i < 52; i++) {
			int index = getRandom();
			swap(i, index);
		}
	}

	private void swap(int i, int index) {
		Card temp = deck[i];
		deck[i] = deck[index];
		deck[index] = temp;
	}
	
	public void clear() {
		front = 0;
		end = 0;
	}

	private int getRandom() {
		Random random = new Random();
		return random.nextInt(52);
	}

	public static void main(String[] args) {
		CardDeck ref = new CardDeck();
		for (Card card : ref.deck) {
			System.out.println(card);
		}
		ref.suffle();
		System.out.println("After suffle....");
		for (Card card : ref.deck) {
			System.out.println(card);
		}
		System.out.println("\n\n\n");
		for (int i = 0; i < 52; i++)
			System.out.println(ref.deal());

	}

}
