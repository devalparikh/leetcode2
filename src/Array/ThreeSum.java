// Leetcode Link: https://leetcode.com/problems/3sum/
// Difficulty: Medium
// Topics: Arrays, Two Pointers

package Array;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {

    }

    // O(n^2 + nlogn) = O(n^2) time
    // Return array of triplets that can sum to 0
    private List<List<Integer>> threeSum(int[] nums) {
        // Sort O(nlogn) or O(n) using radix sort or counting sort
        Arrays.sort(nums);

        HashSet<List<Integer>> allTriplets = new HashSet<List<Integer>>();

        // O(n * n)
        // Iterate through given numbers, stop before second to last element
        for(int i = 0; i < nums.length-2; i++) {
            twoSum(nums, i, 0, allTriplets);
        }

        return new ArrayList<>(allTriplets);
    }

    // O(n) time
    private void twoSum(int[] nums, int i, int target, HashSet<List<Integer>> allTriplets) {
        int left = i + 1;
        int right = nums.length - 1;

        // O(n)
        // Two pointer iteration to find the remaining 2 numbers to sum to target number
        while(left < right) {

            // Current triplet sum
            int tripletSum = nums[i] + nums[left] + nums[right];

            if(tripletSum == target) {
                // Found a correct triplet
                allTriplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
                right--;
            } else if(tripletSum < target) {
                // Triplet too small
                left++;
            } else {
                // Triplet too big
                right--;
            }
        }
    }


}
