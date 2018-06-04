package facebook;

/**
 * Ring buffer is fixed size queue (meaning FIFO) implemented using circular array
 */
public class RingBuffer<T> {
    private final int capacity;
    private int numItems = 0, writePos = 0;
    private final T[] elements;

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        this.elements = (T[]) new Object[capacity];
    }
    public boolean put(T element) {
        if (numItems == capacity) {
            return false;
        }
        elements[writePos++] = element;
        numItems++;
        if (writePos == capacity) {
            writePos = 0;
        }
        return true;
    }

    public T pop() {
        if (numItems == 0) {
            return null;
        }
        int readPos = writePos - numItems;
        if (readPos < 0) {
            readPos = capacity - numItems + writePos;
            // OR readPos = readPos + capacity;  same as above

        }
        T element = elements[readPos];
        numItems--;
        return element;
    }


    public static void main(String[] args) {
        RingBuffer<Character> rb = new RingBuffer(6);
        rb.put('A');
        rb.put('B');
        rb.put('C');
        rb.put('D');
        rb.put('E');
        rb.put('F');
        System.out.println("Should be A: " + rb.pop());
        System.out.println("Should be B: " + rb.pop());
        System.out.println("Should be C: " + rb.pop());
        rb.put('G');
        System.out.println("Should be D: " + rb.pop());
    }
}
