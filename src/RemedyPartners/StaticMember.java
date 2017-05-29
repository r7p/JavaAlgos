package RemedyPartners;

/**
 * Created by Raj on 5/2/2016.
 */
public class StaticMember {
    private static int count = 0;

    public int getCount() {
        return ++count;
    }

    public static void main(String[] args) {
        StaticMember sm1 = new StaticMember();
        StaticMember sm2 = new StaticMember();

        System.out.println(sm1.getCount());
        System.out.println(sm2.getCount());
    }
}
