import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaxSquareLength {

    // Complete the countInversions function below.
    static long maxSquare(List<List<Integer>> arr) {

        long max = 0;
        for(int i=0; i < arr.size(); i++){
            for(int j=0; j < arr.get(i).size(); j++){
                if(i == 0 ||j == 0 || arr.get(i).get(j) == 0)   continue;

                int rowCount=0, colCount=0;
                for(int k=i-1; k>=0; k--){
                    if(arr.get(k).get(j) == 0) break;
                    rowCount++;
                }
                for(int k=j-1; k>=0; k--){
                    if(arr.get(i).get(k) == 0) break;
                    colCount++;
                }

                int min = Math.min(rowCount,colCount);
                int newVal = Math.min(arr.get(i-1).get(j-1),min) + 1;
                if(newVal > 0){
                    arr.get(i).set(j, newVal);
                    if(newVal > max){
                        max = newVal;
                    }
                }
            }
        }

        return max;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/MaxSquareLength"));

        int t = Integer.parseInt(bufferedReader.readLine());

        List<List<Integer>> grid = new ArrayList<>();

        for (int tItr = 0; tItr < t; tItr++) {

            List<Integer> arr = new ArrayList<>();

            String[] arrItems = bufferedReader.readLine().split(" ");

            for (int i = 0; i < t; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr.add(i,arrItem);
            }

            grid.add(tItr,arr);

        }
        long result = maxSquare(grid);
        System.out.println(result);
    }
}
