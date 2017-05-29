import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Raj on 4/28/2016.
 */
public class Prime {

    public void checkPrime(int... n) {
        for (int i = 0; i < n.length; i++) {
            int thisNum = n[i];
            if (thisNum == 2) {
                System.out.println(thisNum);
            }
            if ((thisNum%2)==0) {
                continue;
            }
            boolean isPrime = true;
            for (int j = 3; j * j < thisNum; j+=2) {
                if (thisNum % j == 0) {
                    isPrime = false;
                    break;
                }
             }
            if (isPrime)
                System.out.println(thisNum);
        }

    }

    public static void main(String[] args) {
        new Prime().checkPrime(2,1,3,4,5, 10, 13, 15, 18, 17, 6, 309);
//        try{
//            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//            int n1=Integer.parseInt(br.readLine());
//            int n2=Integer.parseInt(br.readLine());
//            int n3=Integer.parseInt(br.readLine());
//            int n4=Integer.parseInt(br.readLine());
//            int n5=Integer.parseInt(br.readLine());
//            Prime ob=new Prime();
//            ob.checkPrime(n1);
//            ob.checkPrime(n1,n2);
//            ob.checkPrime(n1,n2,n3);
//            ob.checkPrime(n1,n2,n3,n4,n5);
//            Method[] methods=Prime.class.getDeclaredMethods();
//            Set<String> set=new HashSet<>();
//            boolean overload=false;
//            for(int i=0;i<methods.length;i++)
//            {
//                if(set.contains(methods[i].getName()))
//                {
//                    overload=true;
//                    break;
//                }
//                set.add(methods[i].getName());
//
//            }
//            if(overload)
//            {
//                throw new Exception("Overloading not allowed");
//            }
//        }
//        catch(Exception e)
//        {
//            System.out.println(e);
//        }
    }
}
