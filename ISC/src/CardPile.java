public class CardPile {
	protected final int capacity;
	protected int top;
	protected Card[] pile;

	public CardPile (int capacity) {
		this.capacity = capacity;
		this.pile = new Card[capacity];
		this.top = 0;
	}
}
