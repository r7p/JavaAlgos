package RemedyPartners;

/**
 * Created by Raj on 4/25/2016.
 */
public class ASingleton {
    private static ASingleton instance = null;

    private ASingleton() {

    }

    public static ASingleton getInstance() {
        if (instance != null) {
            return instance;
        } else {
            synchronized(ASingleton.class) {
                if (instance == null) {
                    instance = new ASingleton();
                }
            }
            return instance;
        }
    }
}
