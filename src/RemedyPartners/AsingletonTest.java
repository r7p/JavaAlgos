package RemedyPartners;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Raj on 4/25/2016.
 */
public class AsingletonTest {

    public static void main(String[] args) {
        Callable<ASingleton> c1 = () -> ASingleton.getInstance();
        Callable<ASingleton> c2 = () -> ASingleton.getInstance();
        List<Callable<ASingleton>> cs = new ArrayList<>();
        cs.add(c1);
        cs.add(c2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            List<Future<ASingleton>> futures = executorService.invokeAll(cs);
            ASingleton obj1 = futures.get(0).get();
            ASingleton obj2 = futures.get(1).get();
            System.out.println(obj1.equals(obj2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
