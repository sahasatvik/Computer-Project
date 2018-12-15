public class DeckDemo {
	public static void main (String[] args) {
		Deck d = new Deck();
		System.out.println(d);
		d.shuffle();
		d.shuffle();
		System.out.println(d);
		for (int i = 0; i < 26; i++)
			System.out.println(d.deal());
		System.out.println(d);
	}
}
