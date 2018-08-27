import java.util.Iterator;

public class Set implements Iterable<Integer> {
	protected int maxSize;

	/* Simple list setup */
	protected int[] elements;
	protected int top;
	
	/* Let the maximum capacity be specified during instantiation */
	public Set (int maxSize) {
		this.maxSize = maxSize;
		this.elements = new int[maxSize];
		this.top = -1;
	}
	
	/* Returns the number of elements in the set */
	public int getSize () {
		return top + 1;
	}
	
	/* Returns the maximum capacity of the set */
	public int getMaxSize () {
		return maxSize;
	}
	
	/* Expands or contracts the set as necessary, discards elements if
	   they cannot be accomodated */
	public void updateMaxSize (int newMaxSize) {
		int[] temp = new int[newMaxSize];
		this.maxSize = newMaxSize;
		/* Make sure that the top index isn't out of bounds */
		this.top = Math.min(top, newMaxSize - 1);
		/* Copy data to the new list */
		for (int i = 0; i <= top; i++)
			temp[i] = elements[i];
		this.elements = temp;
	}
	
	/* Checks whether an element is present in the set */
	public boolean contains (int n) {
		int i = indexOfEqualOrGreater(n);
		return ((i >= 0) && (i <= top) && (elements[i] == n));
	}
	
	/* Checks whether the set is empty */
	public boolean isEmpty () {
		return top < 0;
	}
	
	/* Clears all elements from the set */
	public void clear () {
		/* Only the top index has to be updated, since values byond it
		   cannot be accessed */
		this.top = -1;
	}
	
	/* Adds an element to the set. Returns 'false' if it is already
	   present, or there isn't enough space. */
	public boolean add (int n) {
		if (getSize() >= getMaxSize())
			return false;
		/* Find the breakpoint to shift elements */
		int i = indexOfEqualOrGreater(n);
		if ((i >= 0) && (i <= top) && (elements[i] == n))
			return false;
		/* Shift elements greater than 'n' to make room for it */
		for (int j = top; j >= i; j--)
			elements[j + 1] = elements[j];
		elements[i] = n;
		top++;
		return true;
	}
	
	/* Removes an element from the set. Returns 'false' if it isn't
	   already present. */
	public boolean remove (int n) {
		if (isEmpty())
			return false;
		/* Find the location of the element */
		int i = indexOfEqualOrGreater(n);
		if ((i < 0) || (i > top) || (elements[i] != n))
			return false;
		/* Shift elements into the desired element, erasing it */
		for (int j = i; j < top; j++)
			elements[j] = elements[j + 1];
		top--;
		return true;
	}
	
	/* Returns the union of two sets */
	public static Set union (Set a, Set b) {
		Set r = new Set(a.getSize() + b.getSize());
		/* The 'add' methods take care of duplicates */
		for (int n : a)
			r.add(n);
		for (int n : b)
			r.add(n);
		return r;
	}
	
	/* Returns the intersection of two sets */
	public static Set intersection (Set a, Set b) {
		Set r = new Set(a.getSize());
		for (int n : a)
			if (b.contains(n))
				r.add(n);
		return r;
	}
	
	/* Returns the difference of two sets */
	public static Set difference (Set a, Set b) {
		Set r = new Set(a.getSize());
		for (int n : a)
			if (!b.contains(n))
				r.add(n);
		return r;
	}
	
	/* Finds the index of the element equal to or greater than
	   the desired element via binary search */
	private int indexOfEqualOrGreater (int n) {
		int hi = top + 1;
		int lo = 0;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (n < elements[mid])
				hi = mid;
			else if (n > elements[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return hi;
	}

	/* Format the set elements as a list */
	@Override
	public String toString () {
		if (getSize() == 0)
			return "[]";
		String s = "";
		for (Integer n : this)
			s += n + " ";
		return "[" + String.join(", ", s.split("\\s+")) + "]";
	}
	
	/* Allow 'Set' to be iterable, providing easy access to elements
	   without indexing */
	@Override
	public Iterator<Integer> iterator () {
		return new Iterator<Integer>() {
			private int currentIndex = 0;
			
			@Override
			public boolean hasNext () {
				return currentIndex <= top;
			}

			@Override
			public Integer next () {
				return elements[currentIndex++];
			}
			
			@Override
			public void remove () {
				throw new UnsupportedOperationException();
			}
		};
	}
}
