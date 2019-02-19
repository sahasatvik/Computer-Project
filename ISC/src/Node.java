public class Node<T> {
        /* Item data is immutable */
        protected final T item;

        /* References to other nodes */
        protected Node<T> left;
        protected Node<T> right;

        /* Set the data item */
        public Node (T item) {
                this.item = item;
        }

        /* Get the data item */
        public T getItem () {
                return item;
        }

        /* Use the data item's 'toString()' method */
        @Override
        public String toString () {
                return item.toString();
        }

        /* Doubly link two nodes */
        public static <T> void link (Node<T> left, Node<T> right) {
                left.right = right;
                right.left = left;
        }
}
