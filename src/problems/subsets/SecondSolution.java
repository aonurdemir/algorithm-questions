package problems.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SecondSolution {
    private long itCount = 0;
    private float runTime = 0;

    public List<List<Integer>> subsets(int[] nums) {
        long startTime = System.currentTimeMillis();
        List<List<Integer>> ret = new ArrayList<>();

        helper(nums, 0, ret);

        runTime = (System.currentTimeMillis() - startTime) / 1000.0f;

        return ret;
    }


    private void helper(int[] nums, int i, List<List<Integer>> ret) {
        itCount++;
        if (i == nums.length - 1) {
            ret.add(new ArrayList<>());
            ret.add(new ArrayList<>(Arrays.asList(nums[i])));
        } else {
            helper(nums, i + 1, ret);
            List<List<Integer>> tmpRet = new ArrayList<>();
            for (List<Integer> integers : ret) {
                itCount++;
                List<Integer> tmp = new ArrayList<>(integers);
                tmp.add(nums[i]);
                tmpRet.add(tmp);
            }

            ret.addAll(tmpRet);
        }

    }

    public static void main(String[] args) {
        SecondSolution s = new SecondSolution();
        s.subsets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30});
        s.iterationCount();
    }

    public void iterationCount() {
        System.out.println(itCount);
    }

    public void getRunTime() {
        System.out.println(runTime);
    }
}