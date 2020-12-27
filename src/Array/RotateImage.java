// Leetcode Link: https://leetcode.com/problems/rotate-image/
// Difficulty: Medium
// Topics: Arrays

package Array;

import java.util.Arrays;

public class RotateImage {

    public static void main (String[] args) {
        int[][] test1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println("Before: " + Arrays.deepToString(test1));
        rotate(test1);
        System.out.println("After: " + Arrays.deepToString(test1));
    }

    private static void rotate(int[][] matrix) {
        int size = matrix.length-1;
        int layer_count = matrix.length/2;

        // Iterate through each matrix layer
        for(int i = 0; i < layer_count; i++) {
            for(int j = i; j < size-i; j++) {
                // Obtain corners
                int one = matrix[i][j]; // top left
                int two = matrix[j][size-i]; // top right
                int three = matrix[size-i][size-j]; // bottom right
                int four = matrix[size-j][i]; // bottom left

                // Swap corners
                matrix[i][j] = four;
                matrix[j][size-i] = one;
                matrix[size-i][size-j] = two;
                matrix[size-j][i] = three;

            }
        }
    }

}
