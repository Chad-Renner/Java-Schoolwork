package GenericsAndCollections;

public class Card {
	private SuitType suit;
	private FaceType face;
	
	public SuitType getSuit() {
		return suit;
	}
	public void setSuit(SuitType suit) {
		this.suit = suit;
	}
	public FaceType getFace() {
		return face;
	}
	public void setFace(FaceType face) {
		this.face = face;
	}
	public String toString() {
		return getFace().name() + " of " + getSuit().name();
	}
	public Card(SuitType suit, FaceType face) {
		setSuit(suit);
		setFace(face);
	}
}
