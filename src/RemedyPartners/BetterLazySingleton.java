package RemedyPartners;

/**
 * Created by Raj on 5/30/2016.
 */
public class BetterLazySingleton {

    /**
     * private constructor
     */
    private BetterLazySingleton() {

    }

    private static class ResourceHolder {
        public static BetterLazySingleton resource = new BetterLazySingleton();
    }

    public static BetterLazySingleton getResource() {
        return ResourceHolder.resource;
    }
}
