package GenericsAndCollections;

public class Main {

	public static void main(String[] args) {
		final int handSize = 5;
		Deck demoDeck = new Deck();
		CardPlayer demoPlayer = new CardPlayer();
		
		demoDeck.shuffle();
		for (int x = 0; x < handSize; x++) {
			demoPlayer.getCard(demoDeck.deal());
		}
		System.out.println("Player's cards:\n");
		demoPlayer.showCards();
	}

}
