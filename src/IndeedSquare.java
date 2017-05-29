import java.util.Scanner;

/**
 * Created by Raj on 4/20/2016.
 */
public class IndeedSquare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine());
        String[] _arr = new String[_arr_size];
        String _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            try {
                _arr_item = in.nextLine();
            } catch (Exception e) {
                _arr_item = null;
            }
            _arr[_arr_i] = _arr_item;
        }

        count_Squares(_arr);

    }

    static void count_Squares(String[] arr) {
        for(String inLine: arr) {
            String[] strInts = inLine.split(" ");
            int a = Integer.parseInt(strInts[0]);
            int b = Integer.parseInt(strInts[1]);
            int squareCount = 0;
            for (int i = a; i <=b ; i++) {
                int sqrt = (int) Math.sqrt(i);
                if (sqrt*sqrt == i) {
                    squareCount++;
                }
            }
            System.out.println(squareCount);
        }

    }
}
