package neetcode.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    static void backtrack(List<List<Integer>> permutations, List<Integer> tmpList, int[] nums) {
        if (tmpList.size() == nums.length) {
            permutations.add(new ArrayList<>(tmpList));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if (tmpList.contains(nums[i]))
                    continue;
                tmpList.add(nums[i]);
                backtrack(permutations, tmpList, nums);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(permutations, new LinkedList<>(), a);
        System.out.println(permutations);
    }
}
