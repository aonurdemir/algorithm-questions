import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String className = "FraudulentActivity";
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input/"+className));

        String[] nd = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] expenditure = new int[n];

        String[] expenditureItems =bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = FraudulentActivity.activityNotifications(expenditure, d);

        System.out.println(result);
    }
}
