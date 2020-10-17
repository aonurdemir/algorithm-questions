import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Booking2 {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        return 1;    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/MergeSortCountInversions"));

        int t = Integer.parseInt(bufferedReader.readLine());


        for (int tItr = 0; tItr < t; tItr++) {
            int n =  Integer.parseInt(bufferedReader.readLine());

            int[] arr = new int[n];

            String[] arrItems = bufferedReader.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);
            System.out.println(result);
        }
    }
}
