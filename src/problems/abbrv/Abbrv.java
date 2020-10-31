package problems.abbrv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

class Abbrv {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        HashSet<Character> set = new HashSet<>();

        for (char c : b.toCharArray()) {
            set.add(Character.toLowerCase(c));
        }

        LinkedList<Character> charList = new LinkedList<Character>();
        for (char c : a.toCharArray()) {
            if (!set.contains(c) && c >= 'a' && c <= 'z') {
                continue;
            }
            charList.add(c);
        }

        int i = 0, j = 0;
        while (j < b.length() && i < charList.size()) {
            int count = 0;
            while(i < charList.size()-1 && Character.toLowerCase(charList.get(i)) == Character.toLowerCase(charList.get(i+1))){
                i++;
                count++;
            }
            int targetCount = 0;
            while(j < b.length()-1 && b.charAt(j) == b.charAt(j+1)){
                targetCount++;
                j++;
            }

            if(count >= targetCount){
                if (Character.toLowerCase(b.charAt(j)) == Character.toLowerCase(charList.get(i))) {
                    i++;
                    j++;
                } else {
                    if (Character.isLowerCase(charList.get(i))) {
                        i++;
                    } else {
                        return "NO";
                    }
                }
            }

        }

        if(j < b.length()){
            return "NO";
        }

        while (i < charList.size()) {
            if (Character.isLowerCase(charList.get(i))) {
                i++;
            } else {
                return "NO";
            }
        }

        return "YES";

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
