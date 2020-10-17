import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxSubarraySum {

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long M) {
        long[] prefix = new long[a.length];

        long curr = 0;
        for(int i = 0; i < a.length; i ++) {
            curr = (a[i] % M + curr) % M;
            prefix[i] = curr;
        }

        long ret = 0;
        SortedSet<Long> treeSet = new TreeSet<>();
        long ec = 0;

        HashMap<Long,Set<Long>> map = new HashMap<>();
        for(int i = 0; i < a.length; i ++) {
            Set<Long> subSet;
            if(map.containsKey(prefix[i]+1)){
                subSet = map.get(prefix[i]+1);
            }
            else{
                subSet = treeSet.tailSet(prefix[i]+1);
            }

            for (Long aLong : treeSet) {
                ec++;
                ret = Math.max(ret, (prefix[i] - ((long) aLong) + M) % M);
            }


            ret = Math.max(ret, prefix[i]); // Don't forget sum from beginning.
            treeSet.add(prefix[i]);
        }

        System.out.println("loop count:" + a.length);
        System.out.println("iteration count:" + ec);
        System.out.println("total:" + (a.length*ec));
        return ret;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/MaxSubarraySum"));
        int q = Integer.parseInt(bufferedReader.readLine());


        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = bufferedReader.readLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = bufferedReader.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);
            System.out.println(String.valueOf(result));
        }
    }
}
