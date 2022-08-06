import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'fiveStarReviews' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY productRatings
     *  2. INTEGER ratingThreshold
     */

    public static int fiveStarReviews(List<List<Integer>> productRatings, int ratingThreshold) {


        float target = (((float)ratingThreshold) / 100) * productRatings.size();


        PriorityQueue<List<Integer>> q = new PriorityQueue<>(new RatioComparator());

        float ratio = 0.0f;
        for(List<Integer> rating : productRatings){
            ratio += ((float)rating.get(0)/ rating.get(1));

            q.add(rating);
        }


        int count = 0;
        while(ratio < target){
            List<Integer> rating = q.poll();

            float oldRatio = ((float)rating.get(0)/ rating.get(1));
            rating.set(0, rating.get(0)+1);
            rating.set(1, rating.get(1)+1);
            float newRatio = ((float)rating.get(0)/ rating.get(1));

            ratio -= oldRatio;
            ratio += newRatio;

            q.add(rating);
            count++;

        }

        return count;

    }




    static class RatioComparator implements Comparator<List<Integer>>{
        public int compare(List<Integer>  a, List<Integer>  b){
            float diffa = (((float)a.get(0))+1 / ((float)a.get(1))+1) - (((float)a.get(0)) / ((float)a.get(1) ));
            float diffb = (((float)b.get(0))+1 / ((float)b.get(1))+1) - (((float)b.get(0)) / ((float)b.get(1) ));


            return diffa < diffb ? 1 : -1;
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int productRatingsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int productRatingsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> productRatings = new ArrayList<>();

        IntStream.range(0, productRatingsRows).forEach(i -> {
            try {
                productRatings.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int ratingThreshold = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.fiveStarReviews(productRatings, ratingThreshold);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
