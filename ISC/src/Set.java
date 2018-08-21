import java.util.Iterator;

public class Set implements Iterable<Integer> {
	protected int maxSize;
	protected int[] elements;
	protected int top;

	public Set (int maxSize) {
		this.maxSize = maxSize;
		this.elements = new int[maxSize];
		this.top = -1;
	}

	public int getSize () {
		return top + 1;
	}

	public int getMaxSize () {
		return maxSize;
	}

	public void updateMaxSize (int newMaxSize) {
		int[] temp = new int[newMaxSize];
		this.maxSize = newMaxSize;
		this.top = Math.min(top, newMaxSize - 1);
		for (int i = 0; i <= top; i++)
			temp[i] = elements[i];
		this.elements = temp;
	}

	public boolean contains (int n) {
		int i = indexOfEqualOrGreater(n);
		return ((i >= 0) && (i <= top) && (elements[i] == n));
	}

	public boolean isEmpty () {
		return top < 0;
	}

	public void clear () {
		this.top = -1;
	}

	public boolean add (int n) {
		if (getSize() >= getMaxSize())
			return false;
		int i = indexOfEqualOrGreater(n);
		if ((i >= 0) && (i <= top) && (elements[i] == n))
			return false;
		for (int j = top; j >= i; j--)
			elements[j + 1] = elements[j];
		elements[i] = n;
		top++;
		return true;
	}

	public boolean remove (int n) {
		if (isEmpty())
			return false;
		int i = indexOfEqualOrGreater(n);
		if ((i < 0) || (i > top) || (elements[i] != n))
			return false;
		for (int j = i; j < top; j++)
			elements[j] = elements[j + 1];
		top--;
		return true;
	}

	public static Set union (Set a, Set b) {
		Set r = new Set(a.getSize() + b.getSize());
		for (int n : a)
			r.add(n);
		for (int n : b)
			r.add(n);
		return r;
	}

	public static Set intersection (Set a, Set b) {
		if (a.getSize() > b.getSize()) {
			Set t = a;
			a = b;
			b = t;
		}
		Set r = new Set(a.getSize());
		for (int n : a)
			if (b.contains(n))
				r.add(n);
		return r;
	}
	
	public static Set difference (Set a, Set b) {
		Set r = new Set(a.getSize());
		for (int n : a)
			if (!b.contains(n))
				r.add(n);
		return r;
	}

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

	@Override
	public String toString () {
		if (getSize() == 0)
			return "[]";
		String s = "[";
		for (Integer n : this)
			s += n + ", ";
		return s.replaceAll(", $", "\\]");
	}

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
