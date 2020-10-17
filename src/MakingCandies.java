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
        return helper(m,w,p,0,n);
    }

    static long helper(long m, long w, long price, long candies, long target){
        long ret = 0;
        long spent = Long.MAX_VALUE;
        while(candies < target){
            if(candies < price){
                long required = price-candies;
                long iterationNeeded = (long)Math.ceil((double)required / (m*w));
                candies = candies+(m*w*iterationNeeded);
                ret+=iterationNeeded;
            }
            else{
                if(m*w >= target-candies){
                    candies = candies+m*w;
                    ret++;
                }
                else{
                    long available = candies / price;
                    if(Math.abs(m-w) >= available){
                        if(m>w){
                            w += available;
                        }
                        else{
                            m+= available;
                        }
                    }else{
                        long diff = Math.abs(m-w);
                        long rem = available - diff;
                        if(m > w){
                            w+=diff;
                        }
                        else{
                            m += diff;
                        }
                        //distribute evenly
                        long share = rem/2;
                        long otherShare = rem - share;

                        m+=share;
                        w+=otherShare;
                    }

                    candies = candies+m*w-(available*price);
                    ret++;
                }
            }

            spent = (long)Math.min(spent, ret + Math.ceil((double)(target-candies)/(m*w)));

        }

        return Math.min(ret,spent);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/MakingCandies/MakingCandies4"));
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
