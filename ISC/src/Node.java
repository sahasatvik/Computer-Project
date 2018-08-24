public class Node<T> {
	protected final T item;
	protected Node<T> left;
	protected Node<T> right;
	
	public Node (T item) {
		this.item = item;
	}
	
	public T getItem () {
		return item;
	}
	
	@Override
	public String toString () {
		return item.toString();
	}

	public static <T> void link (Node<T> left, Node<T> right) {
		left.right = right;
		right.left = left;
	}
}
