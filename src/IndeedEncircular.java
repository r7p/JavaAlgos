import java.util.Scanner;

/**
 * Created by Raj on 4/20/2016.
 */
public class IndeedEncircular {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");

        String res;
        String _commands;
        try {
            _commands = in.nextLine();
        } catch (Exception e) {
            _commands = null;
        }

        res = doesCircleExist(_commands);

            System.out.println(res);

    }

    static String doesCircleExist(String commands) {
        char[] arCommands = commands.toCharArray();
       Point point = new Point();
        char direction = 'N';
        for(char cmd: arCommands) {
            switch (cmd) {
                case 'G':
                    cmdG(direction, point);
                    break;
                case 'L':
                    direction = cmdL(direction,point);
                    break;
                case 'R':
                    direction = cmdR(direction, point);
                    break;
            }
        }
        System.out.println("X: " + point.getX() + ", Y:" + point.getY());

        return "NO";
    }

    static void cmdG(char curDirection, Point point) {
        switch (curDirection) {
            case 'N':
                point.incY();
                break;
            case 'S':
                point.decY();
                break;
            case 'E':
                point.incX();
                break;
            case 'W':
                point.decX();
                break;
        }
    }

    static char cmdL(char curDirection, Point point) {
        switch (curDirection) {
            case 'N':
                point.decX();
                return 'W';
            case 'S':
                point.incX();
                return 'E';
            case 'E':
                point.incY();
                return 'N';
            case 'W':
                point.decY();
                return 'S';
        }
        return curDirection;
    }

    static char cmdR(char curDirection, Point point) {
        switch (curDirection) {
            case 'N':
                point.incX();
                return 'E';
            case 'S':
                point.decX();
                return 'W';
            case 'E':
                point.decY();
                return 'S';
            case 'W':
                point.incY();
                return 'N';
        }
        return curDirection;
    }

    private static class Point {
        int x = 0, y = 0;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void incX() {
            x++;
        }
        public void decX() {
            x--;
        }
        public void incY() {
            y++;
        }
        public void decY() {
            y--;
        }
    }

}
