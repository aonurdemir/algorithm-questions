import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class SwapNodes {

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {

        int[][] response = new int[queries.length][indexes.length];
        for(int i=0; i<queries.length; i++){
            int k = queries[i];

            int root = 1;
            int depth = 1;

            traverse(indexes,root,depth,k);

            List<Integer> ret = new ArrayList<Integer>();
            print(indexes,root,ret);

            for(int j=0; j<ret.size(); j++){
                response[i][j] = ret.get(j);
            }


        }

        return response;
    }

    static void traverse(int[][] indexes, int parent, int depth, int k){
        if(parent == -1) return;

        int parentIndex = parent-1;

        if(depth % k == 0){
            int temp = indexes[parentIndex][0];
            indexes[parentIndex][0] = indexes[parentIndex][1];
            indexes[parentIndex][1] = temp;
        }

        traverse(indexes,indexes[parentIndex][0],depth+1,k);
        traverse(indexes,indexes[parentIndex][1],depth+1,k);
    }

    static void print(int[][] indexes, int parent, List<Integer> ret){
        if(parent == -1){
            return;
        }

        int parentIndex = parent - 1;

        print(indexes,indexes[parentIndex][0],ret);
        ret.add(ret.size(), parent);
        print(indexes,indexes[parentIndex][1],ret);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/SwapNodes"));


        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = bufferedReader.readLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(bufferedReader.readLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                System.out.print(String.valueOf(result[resultRowItr][resultColumnItr]));


                if (resultColumnItr != result[resultRowItr].length - 1) {
                    System.out.print(" ");

                }
            }

            if (resultRowItr != result.length - 1) {
                System.out.println("");
            }
        }
    }
}
