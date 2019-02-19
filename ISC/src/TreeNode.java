public class TreeNode<T extends Comparable<T>> {
        /* Item data is immutable */
        protected final T item;

        /* References to child nodes */
        public TreeNode<T> left;
        public TreeNode<T> right;

        /* Set the data item */
        public TreeNode (T item) {
                this.item = item;
                this.left = null;
                this.right = null;
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
}
