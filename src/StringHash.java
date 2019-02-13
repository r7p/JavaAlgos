

public class StringHash {

    static long computeHash(String s) {
        int p = 31;
        int m = 1000000009;
        long hash = 0;
        long p_pow = 1;
        for (char c:s.toCharArray()) {
            hash = (hash + c * p_pow) % m;
            p_pow = (p_pow * p) % m;
        }

        return hash;
    }

    public static void main(String[] args) {
        System.out.println("computed " + computeHash("polynomial rolling hash function"));
        System.out.println("native " + "polynomial rolling hash function".hashCode());
    }
}
