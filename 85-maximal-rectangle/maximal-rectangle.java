class Solution {
    public int maximalRectangle1(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return 0;
    }

    int[] height = new int[matrix[0].length];
    int maxArea = 0;

    for (int i = 0; i < matrix.length; i++) {
        // Update the height array based on the current row
        for (int j = 0; j < matrix[i].length; j++) {
            height[j] = matrix[i][j] == '0' ? 0 : 1 + height[j];
        }

        // Calculate the maximum rectangle area for the current row
        maxArea = Math.max(maxArea, largestRectangleArea(height));
    }

    return maxArea;
}

private int largestRectangleArea(int[] heights) {
    int maxArea = 0;
    int[] stack = new int[heights.length + 1];
    int top = -1;

    for (int i = 0; i <= heights.length; i++) {
        int currHeight = (i == heights.length) ? 0 : heights[i];

        while (top != -1 && currHeight < heights[stack[top]]) {
            int h = heights[stack[top--]];
            int w = (top == -1) ? i : i - stack[top] - 1;
            maxArea = Math.max(maxArea, h * w);
        }

        stack[++top] = i;
    }

    return maxArea;
}

    public int maximalRectangle(char[][] matrix) {
        return maximalRectangle1(matrix);
        // int[] height = new int[matrix[0].length];
        // int max = 0;
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[i].length; j++) {
        //         height[j] = matrix[i][j] == '0' ? 0 : 1 + height[j];
        //     }
        //     int low = 0, high = 0, min = 0;
        //     while (high < height.length) {
        //         max = Math.max(max, height[high]);
        //         if (height[high] == 0) {
        //             max = Math.max(max, min * (high - low));
        //             low = high + 1;
        //             min = 0;
        //         } else {
        //             min = (min == 0) ? height[high] : Math.min(min, height[high]);
        //         }
        //         high++;
        //     }
        //     while (low < height.length) {
        //         max = Math.max(max, min * (high - low)); // Corrected
        //         low++;
        //     }
        // }
        // return max;
    }
}