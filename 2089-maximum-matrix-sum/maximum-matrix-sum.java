class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long ans = 0; // Total sum of absolute values
        int countOfNegatives = 0; // Count of negative elements
        int smallest = Integer.MAX_VALUE; // Smallest absolute value
        boolean isZero = false; // Check if zero exists

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int ele = matrix[i][j];
                if (ele < 0) countOfNegatives++; // Count negative numbers
                if (ele == 0) isZero = true; // Check for zero
                ele = Math.abs(ele); // Take absolute value
                smallest = Math.min(smallest, ele); // Update smallest absolute value
                ans += ele; // Add to the sum
            }
        }

        // If there's an odd number of negatives and no zero, subtract twice the smallest value
        if (countOfNegatives % 2 != 0 && !isZero) {
            ans -= 2 * smallest;
        }

        return ans;
    }
}
