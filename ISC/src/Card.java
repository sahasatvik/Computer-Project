public class Card {
	public final Suit suit;
	public final Rank rank;
	
	public static final String rankShort = "   A 2 3 4 5 6 7 8 910 J Q K";

	public Card (Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	@Override
	public String toString () {
		return rank + " of " + suit;
	}

	public String toStringShort () {
		int r = rank.getValue();
		String rs = rankShort.substring(2 * r, 2 * (r + 1)).trim();
		char ss = suit.toString().charAt(0);
		return rs + ss;
	}
}
