public class DeckDemo {
        public static void main (String[] args) {
                /* Create a new deck of cards in standard order */
                Deck d = new Deck();
                System.out.println(d);

                /* Shuffle the deck */
                d.shuffle();
                System.out.println(d);

                /* Deal out 26 cards */
                for (int i = 0; i < 26; i++)
                        System.out.println(d.deal());

                /* Show the deck */
                System.out.println(d);
        }
}
