public class QueueDemo {
	public static void main (String[] args) {
		/* Create an integer queue */
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
		
		/* Enqueue random numbers to the queue */
		for (int i = 0; i < (10 + (int) (10 * Math.random())); i++) {
			Integer n = (int) (100 * Math.random());
			System.out.printf("Enqueuing : %s\n", n);
			q.enqueue(n);
		}
		/* Demonstrate simple output formatting */
		System.out.printf("Queue[%2d] : %s\n", q.size(), q);
		
		/* Demonstrate peeking */
		System.out.printf("Number about to be dequeued : %s\n", q.peek());
		
		/* Demonstrate the FIFO principle in effect */
		System.out.println("(Dequeuing 10 numbers)");
		for (int i = 0; i < 10; i++)
			System.out.printf("Dequeuing : %s\n", q.dequeue());
		System.out.printf("Queue[%2d] : %s\n", q.size(), q);
		
		/* Demonstrate iteration until empty */
		System.out.println("(Dequeueing until empty)");
		while (!q.isEmpty())
			System.out.printf("Dequeuing : %s\n", q.dequeue());
		System.out.printf("Queue[%2d] : %s\n", q.size(), q);
	}
}
