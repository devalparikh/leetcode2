package Array;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static void main(String args[]) {

    }
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> allPermutations = new ArrayList<>();

        getALlPermutations(nums, allPermutations, new ArrayList<>());
        return allPermutations;
    }

    private void getALlPermutations(int[] nums, List<List<Integer>> allPermutations, List<Integer> curPermutations) {

        // Base case: all integers added to curPermutations
        if(curPermutations.size() == nums.length) {
            allPermutations.add(new ArrayList<>(curPermutations));
            return;
        }

        // At each recursive call, go through all possible given numbers
        for(int i = 0; i < nums.length; i++) {

            // Avoid duplicates, only adds next value in permutation (not previous values as well)
            if(!curPermutations.contains(nums[i])) {

                // Add next integer
                curPermutations.add(nums[i]);

                // Recursive call
                getALlPermutations(nums, allPermutations, curPermutations);


                // Backtracking below //

                // Remove last element to use for next permutation
                curPermutations.remove(curPermutations.size()-1);
            }
        }

    }
}
