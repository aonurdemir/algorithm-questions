package problems.subsets;

public class Test {

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};




        Subsets s1 = new Subsets();
        s1.subsets(input);
        s1.iterationCount();
        s1.getRunTime();



        SecondSolution s2 = new SecondSolution();
        s2.subsets(input);
        s2.iterationCount();
        s2.getRunTime();

    }

}
