
public class Rajesh_CodingInterview {
    public Rajesh_CodingInterview() {
    }
    /**
     * A Stack interface
     *
     * @param <T> a concrete type
     */
    public interface Stack<T> {
        /**
         * Pop an element off the stack; return {@code null} if no element exists
         *
         * @return an element or {@code null}
         */
        public T pop();
        /**
         * Push an element onto the stack
         *
         * @param e an element
         */
        public void push(T e);
        /**
         * Return the size of the stack
         *
         * @return size of stack
         */
        public int size();
    }
    /**
     * A Queue interface
     *
     * @param <T> a concrete type
     */
    public interface Queue<T> {
        /**
         * Dequeue an element; return {@code null} if no element exists
         *
         * @return element or {@code null}
         */
        public T dequeue();
        /**
         * Enqueue an element onto the queue
         *
         * @param e an element
         */
        public void enqueue(T e);
        /**
         * Return the size of the queue
         *
         * @return size of the queue
         */
        public int size();
    }
    /**
     * A very basic implementation of {@link Stack}
     *
     * @param <T> concrete type
     */
    public final class DefaultStack<T> implements Stack<T> {
        Node<T> top;
        private int size = 0;
        @Override
        public T pop() {
            if (top == null) {
                return null;
            }
            T r = top.value;
            top = top.next;
            size--;
            return r;
        }
        @Override
        public void push(T e) {
            top = new Node<>(e, top);
            size++;
        }
        @Override
        public int size() {
            return size;
        }
        class Node<T> {
            Node(T value, Node<T> next) {
                this.value = value;
                this.next = next;
            }
            T value;
            Node<T> next;
        }
    }
    /* assignment below */
    /**
     * A queue implementation that does not use any collections other than
     * {@link Stack}
     *
     * @param <T> concrete type
     */
    public final class MyQueue<T> implements Queue<T> {
        final Stack<T> myStack;

        public MyQueue() {
            this.myStack = new DefaultStack<>();
        }

        @Override
        public T dequeue() {
            if (myStack.size() == 0) {
                return null;
            }
            Stack<T> tmpStack = new DefaultStack<>();
            while (myStack.size() > 0) {
                tmpStack.push(myStack.pop());
            }
            T returnValue = tmpStack.pop();
            while (tmpStack.size() > 0) {
                myStack.push(tmpStack.pop());
            }
            return returnValue;
        }
        @Override
        public void enqueue(T e) {
            myStack.push(e);
        }
        @Override
        public int size() {
            return myStack.size();
        }
    }
    /**
     * A stack implementation that does not use any collections other than
     * {@link MyQueue}
     *
     * @param <T> concrete type
     */
    public final class QueueStack<T> implements Stack<T> {
        MyQueue<T> queue = new MyQueue<>();
        @Override
        public T pop() {

            return null;
        }
        @Override
        public void push(T e) {
            queue.enqueue(e);
        }
        @Override
        public int size() {
            return queue.size();
        }
    }
    /* tests below */
    public void testSize() {
        System.out.println("===================================");
        System.out.println("testSize");
        Queue<String> myQueue = new MyQueue<>();
        System.out.println(myQueue.size() == 0);
        myQueue.enqueue("a");
        System.out.println(myQueue.size() == 1);
        myQueue.dequeue();
        System.out.println(myQueue.size() == 0);
    }
    public void testBasicQueueBehavior() {
        System.out.println("===================================");
        System.out.println("testBasicQueueBehavior");
        Queue<String> myQueue = new MyQueue<>();
        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.enqueue("c");
        System.out.println(myQueue.dequeue().equals("a"));
        System.out.println(myQueue.dequeue().equals("b"));
        System.out.println(myQueue.dequeue().equals("c"));
        System.out.println(myQueue.dequeue() == null);
    }
    public void testInterleavedQueueDeque() {
        System.out.println("===================================");
        System.out.println("testInterleavedQueueDeque");
        Queue<String> myQueue = new MyQueue<>();
        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.enqueue("c");
        System.out.println(myQueue.dequeue().equals("a"));
        System.out.println(myQueue.dequeue().equals("b"));
        myQueue.enqueue("d");
        myQueue.enqueue("e");
        System.out.println(myQueue.dequeue().equals("c"));
        System.out.println(myQueue.dequeue().equals("d"));
        System.out.println(myQueue.dequeue().equals("e"));
        System.out.println(myQueue.dequeue() == null);
    }
    /* stack tests */
    public void testStackSize() {
        System.out.println("===================================");
        System.out.println("testStackSize");
        Stack<String> myStack = new QueueStack<>();
        System.out.println(myStack.size() == 0);
        myStack.push("a");
        System.out.println(myStack.size() == 1);
        myStack.pop();
        System.out.println(myStack.size() == 0);
    }
    public void testBasicStackBehavior() {
        System.out.println("===================================");
        System.out.println("testBasicStackBehavior");
        Stack<String> myStack = new QueueStack<>();
        myStack.push("a");
        myStack.push("b");
        myStack.push("c");
        System.out.println(myStack.pop().equals("c"));
        System.out.println(myStack.pop().equals("b"));
        System.out.println(myStack.pop().equals("a"));
        System.out.println(myStack.pop() == null);
    }
    public void testInterleavedStackPop() {
        System.out.println("===================================");
        System.out.println("testInterleavedStackPop");
        Stack<String> myStack = new QueueStack<>();
        myStack.push("a");
        myStack.push("b");
        myStack.push("c");
        System.out.println(myStack.pop().equals("c"));
        System.out.println(myStack.pop().equals("b"));
        myStack.push("d");
        myStack.push("e");
        System.out.println(myStack.pop().equals("e"));
        System.out.println(myStack.pop().equals("d"));
        System.out.println(myStack.pop().equals("a"));
        System.out.println(myStack.pop() == null);
    }

    /* queue performance tests */
    public void testPerformanceQueue100() {
        System.out.println("===================================");
        System.out.println("testPerformanceQueue100");
        queuePerfTest(100);
    }
    public void testPerformanceQueue1000() {
        System.out.println("===================================");
        System.out.println("testPerformanceQueue1000");
        queuePerfTest(1000);
    }
    public void testPerformanceQueue10000() {
        System.out.println("===================================");
        System.out.println("testPerformanceQueue10000");
        queuePerfTest(10000);
    }
    public void testPerformanceQueue20000() {
        System.out.println("===================================");
        System.out.println("testPerformanceQueue20000");
        queuePerfTest(20000);
    }
    public void testPerformanceQueue30000() {
        System.out.println("===================================");
        System.out.println("testPerformanceQueue30000");
        queuePerfTest(30000);
    }
    public void testPerformanceQueue40000() {
        System.out.println("===================================");
        System.out.println("testPerformanceQueue40000");
        queuePerfTest(40000);
    }
    public void testPerformanceQueue50000() {
        System.out.println("===================================");
        System.out.println("testPerformanceQueue50000");
        queuePerfTest(50000);
    }
    public void testPerformanceQueue100000() {
        System.out.println("===================================");
        System.out.println("testPerformanceQueue100000");
        queuePerfTest(100000);
    }
    public void testPerformanceQueue1000000() {
        System.out.println("===================================");
        System.out.println("testPerformanceQueue1000000");
        queuePerfTest(1000000);
    }
    private void queuePerfTest(int count) {
        long start = System.currentTimeMillis();
        Queue<Integer> myQueue = new MyQueue<>();
        for (int i = 0; i <= count; i++) {
            myQueue.enqueue(i);
        }
        for (Integer i = 0; i <= count; i++) {
            if(myQueue.dequeue().intValue() != i.intValue()) {
                System.out.println("false");
                return;
            }
            if(System.currentTimeMillis() - start > 10000) {
                System.out.println("failed timeout");
                return;
            }
        }
        System.out.println(myQueue.dequeue() == null);
        long end = System.currentTimeMillis();
        System.out.println(count + "|" + (end - start));
    }
    /* stack performance tests */
    public void testPerformance100() {
        System.out.println("===================================");
        System.out.println("testPerformance100");
        perfTest(100);
    }
    public void testPerformance1000() {
        System.out.println("===================================");
        System.out.println("testPerformance1000");
        perfTest(1000);
    }
    public void testPerformance10000() {
        System.out.println("===================================");
        System.out.println("testPerformance10000");
        perfTest(10000);
    }
    public void testPerformance20000() {
        System.out.println("===================================");
        System.out.println("testPerformance20000");
        perfTest(20000);
    }
    public void testPerformance30000() {
        System.out.println("===================================");
        System.out.println("testPerformance30000");
        perfTest(30000);
    }
    public void testPerformance100000() {
        System.out.println("===================================");
        System.out.println("testPerformance100000");
        perfTest(100000);
    }
    public void testPerformance1000000() {
        System.out.println("===================================");
        System.out.println("testPerformance1000000");
        perfTest(1000000);
    }
    private void perfTest(int count) {
        long start = System.currentTimeMillis();
        Stack<Integer> myStack = new QueueStack<>();
        for (int i = 0; i <= count; i++) {
            myStack.push(i);
        }
        for (Integer i = count; i >= 0; i--) {
            if(myStack.pop().intValue() != i.intValue()) {
                System.out.println("false");
                return;
            }
            if(System.currentTimeMillis() - start > 10000) {
                System.out.println("failed timeout");
                return;
            }
        }
        System.out.println(myStack.pop() == null);
        long end = System.currentTimeMillis();
        System.out.println(count + "|" + (end - start));
    }
    public static void main(String args[]) {
        Rajesh_CodingInterview test = new Rajesh_CodingInterview();
        test.testSize();
        test.testBasicQueueBehavior();
        test.testInterleavedQueueDeque();
        test.testPerformanceQueue100();
        test.testPerformanceQueue1000();
        test.testPerformanceQueue10000();
        test.testPerformanceQueue20000();
        test.testPerformanceQueue30000();
        test.testPerformanceQueue40000();
        test.testPerformanceQueue50000();
        test.testPerformanceQueue100000();
        test.testPerformanceQueue1000000();
        test.testStackSize();
        test.testBasicStackBehavior();
        test.testInterleavedStackPop();
        test.testPerformance100();
        test.testPerformance1000();
        test.testPerformance10000();
        test.testPerformance20000();
        test.testPerformance30000();
        test.testPerformance100000();
        test.testPerformance1000000();
    }
}