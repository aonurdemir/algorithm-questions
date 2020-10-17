import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MergeSortCountInversions {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        return sort(arr,0,arr.length-1);

    }

    static long sort(int[] arr, int l, int r){
        if(l < r){
            int m = l + (r-l)/2;
            long lc = sort(arr, l, m);
            long rc = sort(arr, m+1, r);

            int[] la = Arrays.copyOfRange(arr,l,m+1);
            int[] ra = Arrays.copyOfRange(arr,m+1,r+1);

            long count=0;
            int i=0,j=0,k=l;
            while(i < la.length && j < ra.length){
                if(la[i] <= ra[j]){
                    arr[k] = la[i];
                    i++;
                }
                else{
                    arr[k] = ra[j];
                    count += (m+1+j)-k;
                    j++;
                }
                k++;
            }
            while(i <la.length){
                arr[k] = la[i];
                k++;
                i++;
            }
            while(j < ra.length){
                arr[k] = ra[j];
                j++;
                k++;
            }
            return count+lc+rc;
        }
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       String str = "a s";
        System.out.println(str.replaceAll("[.]",""));
        System.out.println(str.split(" "));
    }
}
