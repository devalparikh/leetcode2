// Leetcode Link: https://leetcode.com/problems/next-permutation/
// Difficulty: Hard
// Topics: Arrays

package Array;

public class NextPermutation {
    public static void main(String args[]) {

    }

    // O(n) time, O(1) space
    public void nextPermutation(int[] nums) {

        // Find target - the item to the left of a strictly decreasing tail section (increasing from the end)
        int i_target = nums.length-2;

        for(int i = nums.length-2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                // Found target
                break;
            }
            i_target = i-1;
        }

        if(i_target < 0) {
            // Reverse whole thing since entire array is strictly decreasing
            reverse(nums, 0);
            return;
        }

        // O(n)
        // Find newTarget - the next greatest number from the target within the strictly decreasing tail section
        int i_newTarget = i_target+1; // (min but larger than target)
        for(int i = i_target+1; i < nums.length; i++) {
            // Could be <= than the previous newTarget to swap with last instance of that value
            if(nums[i] <= nums[i_newTarget] && nums[i] > nums[i_target])  {
                i_newTarget = i;
            }
        }

        // Swap target and newTarget
        swap(nums, i_target, i_newTarget);

        // Reverse strictly decreasing tail section
        reverse(nums, i_target+1);

    }

    // O(n)
    // Reverse array starting from a start index
    private void reverse(int[] nums, int start_index) {

        int i = start_index;
        int j = nums.length - 1;

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    // O(1)
    // Swap in place
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
