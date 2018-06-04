import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 78 : https://leetcode.com/problems/subsets/description/
 *
 * Given a set of distinct integers, nums, return all possible subsetMethod (the power set).
 *
 */
public class Subsets {

    public static List<List<Integer>> subsetMethod(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        //Start with an empty Subset
        result.add(new ArrayList<>());

        for(int n : nums){
            //for each number in a set, iterate over all subsets created so far
            int size = result.size();
            for(int i=0; i<size; i++){
                //make copy of this subset
                List<Integer> subset = new ArrayList<>(result.get(i));
                //add current number to it
                subset.add(n);
                //add it to result subset
                result.add(subset);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        List<List<Integer>> subsets = subsetMethod(a);
        System.out.println(subsets);
    }
}
