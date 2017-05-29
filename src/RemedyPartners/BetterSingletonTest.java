package RemedyPartners;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Raj on 4/25/2016.
 */
public class BetterSingletonTest {

    public static void main(String[] args) {
        Callable<BetterLazySingleton> c1 = () -> BetterLazySingleton.getResource();
        Callable<BetterLazySingleton> c2 = () -> BetterLazySingleton.getResource();
        List<Callable<BetterLazySingleton>> cs = new ArrayList<>();
        cs.add(c1);
        cs.add(c2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            List<Future<BetterLazySingleton>> futures = executorService.invokeAll(cs);
            BetterLazySingleton obj1 = futures.get(0).get();
            BetterLazySingleton obj2 = futures.get(1).get();
            System.out.println(obj1.equals(obj2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
