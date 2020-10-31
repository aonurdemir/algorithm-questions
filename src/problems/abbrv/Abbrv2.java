package problems.abbrv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Abbrv2 {

    static String abbreviation(String a, String b) {
        int[][] dp = new int[a.length()][b.length()];
        for(int i=0; i< a.length(); i++){
            for(int j=0; j < b.length(); j++){
                dp[i][j] = -1;
            }
        }

        if(a.length() < b.length()) return "NO";

        if(helper(a,b,0,0,dp) == 1){
            return "YES";
        }
        else{
            return "NO";
        }
    }

    static int helper(String a, String b, int i, int j,int[][] dp){
        if(i >= a.length() && j < b.length()) return 0;

        if(j >= b.length()){
            for(int k=i; k<a.length(); k++){
                if(Character.isUpperCase(a.charAt(k))){
                    return 0;
                }
            }
            return 1;
        }

        if(dp[i][j] >= 0) return dp[i][j];

        if(Character.isUpperCase(a.charAt(i)) )
        {
            if(a.charAt(i) == b.charAt(j)){
                dp[i][j] = 1;
                return helper(a,b,i+1,j+1,dp);
            }
            else return 0;
        }
        else{
            if(Character.toUpperCase(a.charAt(i))== b.charAt(j)){
                return
                        helper(a,b,i+1,j+1,dp)
                                | helper(a,b,i+1,j,dp);
            }
            else return helper(a,b,i+1,j,dp);
        }

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/Abbr"));

        int q = Integer.parseInt(bufferedReader.readLine());

        for (int qItr = 0; qItr < q; qItr++) {
            String a = bufferedReader.readLine();

            String b = bufferedReader.readLine();

            String result = abbreviation(a, b);
            System.out.println(result);

        }


        scanner.close();
    }
}
