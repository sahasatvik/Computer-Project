import java.util.Iterator;

/* Use generics to allow arbitrary data typed queues, eith type checking 
   enforced at compile-time */
public class LinkedQueue<T> implements Iterable<T> {
	/* Special nodes surrounding data nodes */
	private final Node<T> HEAD = new Node<T>(null);
	private final Node<T> TAIL = new Node<T>(null);
	
	public LinkedQueue () {
		Node.<T>link(TAIL, HEAD);
	}
	
	/* Enqueues a data item of generic type into the head */
	public void enqueue (T item) {
		Node<T> newNode = new Node<T>(item);
		Node.<T>link(HEAD.left, newNode);
		Node.<T>link(newNode, HEAD);
	}
	
	/* Dequeues a data item from the tail */
	public T dequeue () {
		if (this.isEmpty())
			return null;
		Node<T> lastNode = TAIL.right;
		Node.<T>link(TAIL, lastNode.right);
		return lastNode.getItem();
	}
	
	/* Returns the data item at the tail without removing it */
	public T peek () {
		return TAIL.right.getItem();
	}
	
	/* Clears the queue */
	public void clear () {
		/* Garbage collection takes care of orphaned nodes */
		Node.<T>link(TAIL, HEAD);
	}
	
	/* Checks if the queue is empty */
	public boolean isEmpty () {
		return TAIL.right == HEAD;
	}
	
	/* Returns the size of the queue */
	public int size () {
		int n = 0;
		/* Start at the tail */
		Node<T> current = TAIL;
		/* Iterate through all nodes until the head */
		while ((current = current.right) != HEAD)
			n++;
		return n;
	}
	
	/* Format the elements of the queue neatly */
	@Override
	public String toString () {
		String[] elements = new String[this.size()];
		Node<T> current = TAIL;
		int n = 0;
		while ((current = current.right) != HEAD)
			elements[n++] = current.toString();
		return "[" + String.join(", ", elements) + "]";
	}
	
	/* Allow the elements of the queue to be iterated over simply */
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
