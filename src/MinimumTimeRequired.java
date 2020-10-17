import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumTimeRequired {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;

        for(long i : machines){
            if(i < min){
                min = i;
            }
            if(i > max){
                max = i;
            }
        }

        long lower = (long)Math.ceil((float)goal / machines.length*min);
        long upper = (long)Math.ceil((float)goal / machines.length*max);

        while(upper-lower > 1){
            long mid = lower + (upper - lower)/2;
            long total = 0;
            for(long i : machines){
                total += mid / i;
            }
            if(total < goal){
                lower=mid;
            }
            else{
                upper = mid;
            }

        }
        System.out.println(upper);
        return upper;

    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/MinimumTimeRequired"));
        String[] nGoal = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = bufferedReader.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        System.out.println(minTime(machines, goal));

        scanner.close();
    }
}
