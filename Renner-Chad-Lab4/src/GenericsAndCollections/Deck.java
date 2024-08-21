package GenericsAndCollections;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();

	public void shuffle() {
		Collections.shuffle(cards);
	}
	public Card deal() {
		Card dealtCard = cards.get(0);
		cards.remove(dealtCard);
		return dealtCard;
	}
	public Deck() {
		for (int i = 0; i < SuitType.values().length; i++) {
			for (int y = 0; y < FaceType.values().length; y++) {
				Card card = new Card(SuitType.values()[i], FaceType.values()[y]);
				cards.add(card);
			}
		}
	}
}
