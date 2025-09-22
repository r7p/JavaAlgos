package neetcode.bloomberg;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 *
 */
public class UniqueInStream {
    final private Set<Integer> dataSet = new HashSet<>();
    final private LinkedList<Integer> unique = new LinkedList<>();

    public UniqueInStream() {
        // do intialization if necessary
    }

    /**
     * Adds integer num to a stream of integers.
     */
    public void add(int num) {
        Integer thisInt = num;
        if (dataSet.contains(thisInt)) {
            // this integer is no longer unique
            unique.remove(thisInt);
        } else {
            dataSet.add(thisInt);
            unique.offer(thisInt);
        }
    }

    /**
     *  Returns the first unique integer in the stream if found else return null.
     */
    public Integer getFirstUnique() {
        return unique.peekFirst();
    }

    public static void main(String[] args) {
        UniqueInStream s = new UniqueInStream();
        s.add(2);
        System.out.println(s.getFirstUnique()); // 2
        s.add(2);
        System.out.println(s.getFirstUnique()); // null
        s.add(3);
        System.out.println(s.getFirstUnique()); // 3
        s.add(4);
        System.out.println(s.getFirstUnique()); // 3
        s.add(3);
        System.out.println(s.getFirstUnique()); // 4
    }
}
