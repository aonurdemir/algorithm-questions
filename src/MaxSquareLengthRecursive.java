import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxSquareLengthRecursive {

    static long[][] dp;

    // Complete the countInversions function below.
    static long maxSquare(List<List<Integer>> arr) {
        dp = new long[arr.size() + 1][arr.get(0).size() + 1];
        for (int i = 0; i < arr.size() + 1; i++) {
            for (int j = 0; j < arr.get(0).size() + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(arr,0,0);

    }

    static long helper(List<List<Integer>> arr, int i, int j) {
        if (dp[i][j] != -1) return dp[i][j];

        if (i == arr.size() || j == arr.get(i).size() || arr.get(i).get(j) == 0) {
            dp[i][j] = 0;
            return 0;
        }

        long count = Math.min(
                helper(arr, i, j + 1),
                Math.min(
                        helper(arr, i + 1, j),
                        helper(arr, i + 1, j + 1)
                )
        );

        dp[i][j] = count + 1;

        return count;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/MaxSquareLength"));

        int testCount = Integer.parseInt(bufferedReader.readLine());

        for(int k=0; k < testCount; k++){
            int dimension = Integer.parseInt(bufferedReader.readLine());

            List<List<Integer>> grid = new ArrayList<>();
            for (int tItr = 0; tItr < dimension; tItr++) {

                List<Integer> arr = new ArrayList<>();

                String[] arrItems = bufferedReader.readLine().split(" ");

                for (int i = 0; i < dimension; i++) {
                    int arrItem = Integer.parseInt(arrItems[i]);
                    arr.add(i, arrItem);
                }

                grid.add(tItr, arr);

            }

            long result = maxSquare(grid);
            System.out.println(result);
        }


    }
}
