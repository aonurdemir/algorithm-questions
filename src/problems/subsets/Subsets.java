package problems.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    private long itCount=0;
    private float runTime = 0;

    public List<List<Integer>> subsets(int[] nums) {
        long startTime = System.currentTimeMillis();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);


        runTime = (System.currentTimeMillis() - startTime) / 1000.0f;

        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        itCount++;
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            itCount++;
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public void iterationCount(){
        System.out.println(itCount);
    }
    public void getRunTime() {
        System.out.println(runTime);
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        s.subsets(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30});
        s.iterationCount();
    }
}