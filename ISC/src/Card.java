public class Card {
	protected final Suit suit;
	protected final Rank rank;

	public Card (Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	@Override
	public String toString () {
		return rank + " of " + suit;
	}
}
