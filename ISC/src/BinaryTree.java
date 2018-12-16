public class BinaryTree<T extends Comparable<T>> {
	/* The root node is at the top of all other nodes */
	protected TreeNode<T> root;
	
	public BinaryTree (TreeNode<T> root) {
		this.root = root;
	}
	
	/* Default to a 'null' root node */
	public BinaryTree () {
		this(null);
	}
	
	/* Checks whether the tree contains a given item */
	public boolean contains (T item) {
		return this.search(item) != null;
	}
	
	/* Returns the node containing a given item. If not found, returns 'null' */
	public TreeNode<T> search (T item) {
		return BinaryTree.<T>search(root, item);
	}
	
	/* Adds an item to the tree in order, if not already present */
	public void add (T item) {
		root = BinaryTree.<T>add(root, item);
	}
	
	/* Formats the items in the tree neatly, in order */ 
	@Override
	public String toString () {
		return BinaryTree.<T>traverseInOrder(this.root).trim();
	}
	
	/* Recursive binary search */
	public static <T extends Comparable<T>> TreeNode<T> search (TreeNode<T> root, T item) {
		if (item.compareTo(root.item) < 0)
			return BinaryTree.<T>search(root.left, item);
		else if (item.compareTo(root.item) > 0)
			return BinaryTree.<T>search(root.right, item);
		return root;
	}
	
	/* Recursive insertion of a node in a binary tree */
	public static <T extends Comparable<T>> TreeNode<T> add (TreeNode<T> root, T item) {
		if (root == null)
			root = new TreeNode<T>(item);
		else if (item.compareTo(root.item) < 0)
			root.left = BinaryTree.<T>add(root.left, item);
		else if (item.compareTo(root.item) > 0)
			root.right = BinaryTree.<T>add(root.right, item);
		return root;
	}
	
	/* Recursive in order traversal of a binary tree */
	public static <T extends Comparable<T>> String traverseInOrder (TreeNode<T> node) {
		if (node == null)
			return "";
		return traverseInOrder(node.left) + " "
			+ node + " "
			+ traverseInOrder(node.right);
	}
}
