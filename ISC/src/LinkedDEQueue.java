import java.util.Iterator;

/* Extend LinkedQueue<T> to build on existing functionality */
public class LinkedDEQueue<T> extends LinkedQueue<T> {

        /* Enqueues a data item of generic type into the tail */
        public void enqueueRear (T item) {
                Node<T> newNode = new Node<T>(item);
                Node.<T>link(newNode, TAIL.right);
                Node.<T>link(TAIL, newNode);
        }

        /* Dequeues a data item from the head */
        public T dequeueFront () {
                if (this.isEmpty())
                        return null;
                Node<T> firstNode = HEAD.left;
                Node.<T>link(firstNode.left, HEAD);
                return firstNode.getItem();
        }

        /* Descending iterator */
        public Iterator<T> descendingIterator () {
                return new Iterator<T>() {
                        private Node<T> current = HEAD.left;

                        @Override
                                public boolean hasNext () {
                                        return current != TAIL;
                                }

                        @Override
                                public T next () {
                                        T item = current.getItem();
                                        current = current.left;
                                        return item;
                                }

                        @Override
                                public void remove () {
                                        throw new UnsupportedOperationException();
                                }
                };
        }
}
