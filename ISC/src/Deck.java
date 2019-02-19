/* Abstraction of a deck of cards */
public class Deck {
        /* Setup a simple stack */
        protected Card[] cards;
        protected int top;

        public Deck () {
                cards = new Card[52];
                top = -1;
                /* Initialize a full deck */
                for (Suit suit : Suit.values())
                        for (Rank rank : Rank.values())
                                cards[++top] = new Card(suit, rank);
        }

        /* Checks if the deck is empty */
        public boolean isEmpty () {
                return top < 0;
        }

        /* Returns the number of cards in the deck */
        public int size () {
                return top + 1;
        }

        /* Pops the topmost card from the deck */
        public Card deal () {
                if (this.isEmpty())
                        return null;
                return cards[top--];
        }

        /* Shuffles the deck using the Fisher-Yates, or Knuth shuffle */
        public void shuffle () {
                for (int i = top; i > 0; i--) {
                        int j = random(0, i + 1);
                        swap(i, j);
                }
        }

        /* Utility method for swapping cards in the deck */
        private void swap (int i, int j) {
                Card t = cards[i];
                cards[i] = cards[j];
                cards[j] = t;
        }

        /* Format the cards in the deck neatly */
        @Override
        public String toString () {
                if (this.isEmpty())
                        return "[]";
                String s = "[";
                for (int i = top; i >= 0; i--)
                        s += cards[i].toStringShort() + ", ";
                return s.substring(0, s.length() - 2) + "]";
        }

        /* Utility method for generating random integers in a given range */
        private static int random (int lo, int hi) {
                return (int) (lo + (Math.random() * (hi - lo)));
        }
}
