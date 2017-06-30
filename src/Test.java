import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Raj on 4/20/2016.
 */
public class Test {
    public static void main(String[] args) {

        intArrayResize();

    }

    static void intArrayResize() {
        int[] a = new int[2];
        a[0] = 1;
        a[1] = 2;

        System.out.println(Arrays.toString(a));

        a = new int[4];
        System.out.println(Arrays.toString(a));
    }

    static void testStream() {
        List<Integer> alist = Arrays.asList(10,40,20,60,80,0,80,30,40);
        ArrayList<Integer> collect = alist.stream().filter(value -> value > 18)
            .sorted().sequential().map(Integer::new).distinct().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect);
        ArrayList<Integer> collect1 = Arrays.asList(1, 2, 3, 4, 5).stream().skip(2).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect1);
        Arrays.asList("M", "O", "B").parallelStream()
            .filter(f -> {
                System.out.println("FRU" + f);
                return false;
            }).forEach(fruit -> {});
    }

//    static void printMyName(String name) {
//        name=name + "NN";
//        Runnable r = () -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("W" + name);
//        };
//            new Thread(r).start();
//        System.out.println("H" + name);
//    }

    static void showConsumer(String name) {
        System.out.println("Hello " + name);
    }
    static void showConsumer1(Supplier<String> name) {
        System.out.println("Hello " + name.get());
    }
}
