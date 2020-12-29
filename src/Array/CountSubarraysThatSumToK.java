// Leetcode Link: https://leetcode.com/problems/subarray-sum-equals-k/
// Difficulty: Medium
// Topics: Arrays, Hash Table

package Array;

import java.util.HashMap;

public class CountSubarraysThatSumToK {

    // Subarrays - msut be contigious

    public static void main(String args[]) {

    }

    // O(n) time, O(n) space
    public int subarraySum(int[] nums, int k) {

        // Storing cumulative sum
        int sum = 0;

        // Number of subarrays that sum to k
        int count = 0;

        // Map of cumulative sums seen (before i), sum: sum_count (number of times that sum has been seen)
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1); // Init 0

        // Populate cumulative sums array
        for(int i = 1; i < nums.length; i++) {

            // Calculate current cumulative until i
            sum = sum + nums[i];

            // 1. Use hm to see if sum - k has been seen before
            // 2. If sum - k in hm (sum_i - sum_j = k)
            //    Take the sum_count value of sums_j
            // 3. Add/update sum_count for sums_i to hm


            // 1
            // Check if sum-k is in hm
            if(hm.containsKey(sum - k)) {
                // 2
                // Add count of sum-k to total count
                count += hm.get(sum-k);
            }

            // 3
            // Update hm
            if(hm.containsKey(sum)) {
                // Increment count of current sum
                hm.put(sum, hm.get(sum) + 1);
            } else {
                // Add current sum to hm
                hm.put(sum, 1);
            }

        }

        return count;
    }

    // O(n^2) time, O(n) space
    public int subarraySumCumulativeSum(int[] nums, int k) {
        // Storing cumulative sums
        int[] sums = new int[nums.length];
        sums[0] = nums[0];

        // Number of subarrays that sum to k
        int count = 0;

        // O(n)
        // Populate cumulative sums array
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        // O(n+n)
        // Iterate through given numbers
        for (int i = 0; i < nums.length; i++) {
            // Iterate from current index to end of array
            for (int j = i; j < sums.length; j++) {

                // Get the current cumulative sum at end pointer
                int temp = sums[j];

                // On first iteration of i, just account for cumulative sums
                // On the rest of the iterations of i, subtract cumulative sum of i-1
                if (i != 0) {
                    temp -= sums[i - 1];
                }

                if (temp == k) {
                    count++;
                }
            }

        }
        return count;

    }
}
