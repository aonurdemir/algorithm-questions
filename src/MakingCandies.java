import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MakingCandies {

    // Complete the minimumPasses function below.
    static long minimumPasses(long m, long w, long p, long n) {

        long ret = 0;
        return helper(m,w,p,0,n,ret);
    }

    static long helper(long m, long w, long p, long t, long r, long ret){
        if(t >= r) return ret;

        ret++;

        if(t == 0){
            return helper(m,w,p,t+m*w,r,ret);
        }
        else{
            if(m*w >= r-t){
                return helper(m,w,p,t+m*w,r,ret);
            }
            else{
                long available = t / p;
                if(Math.abs(m-w) > available){
                    if(m>w){
                        w += available;
                    }
                    else{
                        m+= available;
                    }
                }else{
                    long rem = available - Math.abs(m-w);
                    if(m > w){
                        w+=Math.abs(m-w);
                    }
                    else{
                        m += Math.abs(m-w);
                    }
                    long share = rem/2;
                    long otherShare = rem - share;
                    m+=share;
                    w+=otherShare;
                }

                return helper(m,w,p,t+m*w-(available*p),r,ret);
            }
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/MakingCandies"));
        String[] mwpn = bufferedReader.readLine().split(" ");

        long m = Long.parseLong(mwpn[0]);

        long w = Long.parseLong(mwpn[1]);

        long p = Long.parseLong(mwpn[2]);

        long n = Long.parseLong(mwpn[3]);

        long result = minimumPasses(m, w, p, n);

        System.out.println(String.valueOf(result));


        scanner.close();
    }
}
