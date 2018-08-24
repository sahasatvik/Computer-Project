public class SetDemo {
	public static void main (String[] args) {
		Set a = new Set(10);
		Set b = new Set(10);
		Set c = new Set(10);
		for (int i = 0; i < 10; i++)
			a.add((int) (Math.random() * 10));
		for (int i = 0; i < 10; i++)
			b.add((int) (Math.random() * 10));
		for (int i = 0; i < 10; i++)
			c.add((int) (Math.random() * 10));
		
		System.out.printf("A [%2d] = %s\n", a.getSize(), a);
		System.out.printf("B [%2d] = %s\n", b.getSize(), b);
		System.out.printf("C [%2d] = %s\n", c.getSize(), c);
		System.out.println();
		System.out.printf("A union B [%2d] = %s\n", Set.union(a, b).getSize(), Set.union(a, b));
		System.out.printf("B union C [%2d] = %s\n", Set.union(b, c).getSize(), Set.union(b, c));
		System.out.printf("C union A [%2d] = %s\n", Set.union(c, a).getSize(), Set.union(c, a));
		System.out.printf("A union B union C [%2d] = %s\n", Set.union(Set.union(a, b), c).getSize(),
									Set.union(Set.union(a, b), c));
		System.out.println();
		System.out.printf("A intersection B [%2d] = %s\n", Set.intersection(a, b).getSize(), Set.intersection(a, b));
		System.out.printf("B intersection C [%2d] = %s\n", Set.intersection(b, c).getSize(), Set.intersection(b, c));
		System.out.printf("C intersection A [%2d] = %s\n", Set.intersection(c, a).getSize(), Set.intersection(c, a));
		System.out.printf("A intersection B intersection C [%2d] = %s\n", Set.intersection(Set.intersection(a, b), c).getSize(),
											Set.intersection(Set.intersection(a, b), c));
		System.out.println();
		System.out.printf("A - B [%2d] = %s\n", Set.difference(a, b).getSize(), Set.difference(a, b));
		System.out.printf("B - C [%2d] = %s\n", Set.difference(b, c).getSize(), Set.difference(b, c));
		System.out.printf("C - A [%2d] = %s\n", Set.difference(c, a).getSize(), Set.difference(c, a));
	}
}
