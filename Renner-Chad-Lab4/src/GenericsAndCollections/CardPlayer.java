package GenericsAndCollections;

import java.util.ArrayList;

public class CardPlayer {
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public void getCard(Card card) {
		hand.add(card);
	}
	public void showCards() {
		System.out.println(hand.toString());
	}
}
