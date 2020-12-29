// Leetcode Link: https://leetcode.com/problems/spiral-matrix/
// Difficulty: Medium
// Topics: Arrays

package Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String args[]) {

    }

    // O(m*n)
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> spiral = new ArrayList<>();

        // Boundaries
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        // Iterate through matrix until boundaries colide
        while(top <= bottom && left <= right) {

            // Top fence
            for(int col = left; col <= right; col++) {
                spiral.add(matrix[top][col]);
            }
            top++;

            // Right fence
            for(int row = top; row <= bottom; row++) {
                spiral.add(matrix[row][right]);
            }
            right--;

            // Bottom Fence
            if(top <= bottom) {
                for(int col = right; col >= left; col--) {
                    spiral.add(matrix[bottom][col]);
                }
            }
            bottom--;

            // Left Fence
            if(left <= right) {
                for(int row = bottom; row >= top; row--) {
                    spiral.add(matrix[row][left]);
                }
            }
            left++;


        }

        return spiral;
    }

}
