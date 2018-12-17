/* Abstraction of a standard playing card */
public class Card {
	/* Each card has an immutable suit and rank */
	public final Suit suit;
	public final Rank rank;
	
	/* Short names of cards */
	public static final String rankShort = "   A 2 3 4 5 6 7 8 910 J Q K";

	public Card (Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	/* Formats the card details neatly */
	@Override
	public String toString () {
		return rank + " of " + suit;
	}
	
	/* Formats the card as a 2-character string */
	public String toStringShort () {
		int r = rank.getValue();
		String rs = rankShort.substring(2 * r, 2 * (r + 1)).trim();
		char ss = suit.toString().charAt(0);
		return rs + ss;
	}
}
