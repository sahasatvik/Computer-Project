import java.util.Iterator;

public class LinkedQueue<T> implements Iterable<T> {
	private final Node<T> HEAD = new Node<T>(null);
	private final Node<T> TAIL = new Node<T>(null);
	
	public LinkedQueue () {
		Node.<T>link(TAIL, HEAD);
	}

	public void enqueue (T item) {
		Node<T> newNode = new Node<T>(item);
		Node<T> previousNode = HEAD.left;
		Node.<T>link(newNode, HEAD);
		Node.<T>link(previousNode, newNode);
	}

	public T dequeue () {
		if (this.isEmpty())
			return null;
		Node<T> lastNode = TAIL.right;
		Node.<T>link(TAIL, lastNode.right);
		return lastNode.getItem();
	}

	public T peek () {
		return TAIL.right.getItem();
	}
	
	public void clear () {
		Node.<T>link(TAIL, HEAD);
	}

	public boolean isEmpty () {
		return TAIL.right == HEAD;
	}

	public int size () {
		int n = 0;
		Node<T> current = TAIL;
		while ((current = current.right) != HEAD)
			n++;
		return n;
	}

	@Override
	public String toString () {
		String[] elements = new String[this.size()];
		Node<T> current = TAIL;
		int n = 0;
		while ((current = current.right) != HEAD)
			elements[n++] = current.toString();
		return "[" + String.join(", ", elements) + "]";
	}

	@Override
	public Iterator<T> iterator () {
		return new Iterator<T>() {
			private Node<T> current = TAIL.right;
			
			@Override
			public boolean hasNext () {
				return current != HEAD;
			}

			@Override
			public T next () {
				T item = current.getItem();
				current = current.right;
				return item;
			}

			@Override
			public void remove () {
				throw new UnsupportedOperationException();
			}
		};
	}
}
