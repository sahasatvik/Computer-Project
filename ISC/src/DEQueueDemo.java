public class DEQueueDemo {
        public static void main (String[] args) {
                /* Create an integer DEqueue */
                LinkedDEQueue<Integer> dq = new LinkedDEQueue<Integer>();

                /* Enqueue random numbers to the front of the DEqueue */
                for (int i = 0; i < (7 + (int) (5 * Math.random())); i++) {
                        Integer n = (int) (100 * Math.random());
                        System.out.printf("Enqueuing (Front) : %s\n", n);
                        dq.enqueue(n);
                }
                /* Enqueue random numbers to the rear of the DEqueue */
                for (int i = 0; i < (7 + (int) (5 * Math.random())); i++) {
                        Integer n = (int) (100 * Math.random());
                        System.out.printf("Enqueuing ( Rear) : %s\n", n);
                        dq.enqueueRear(n);
                }
                /* Demonstrate simple output formatting */
                System.out.printf("DEQueue[%2d] : %s\n", dq.size(), dq);

                /* Dequeue items from the front of the DEQueue */
                System.out.println("(Dequeuing 10 numbers (Front))");
                for (int i = 0; i < 10; i++)
                        System.out.printf("Dequeuing : %s\n", dq.dequeueFront());
                System.out.printf("Queue[%2d] : %s\n", dq.size(), dq);

                /* Dequeue items from the rear of the DEQueue until empty */
                System.out.println("(Dequeueing until empty (Rear))");
                while (!dq.isEmpty())
                        System.out.printf("Dequeuing : %s\n", dq.dequeue());
                System.out.printf("DEQueue[%2d] : %s\n", dq.size(), dq);
        }
}
