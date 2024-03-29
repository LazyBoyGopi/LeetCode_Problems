class Solution {
    public int maxArea(int[] height) {
        int low = 0 , high = height.length-1;
        int maxArea = 0;
        while(low < high)
        {
            maxArea = Math.max(maxArea,(high-low)*Math.min(height[high],height[low]));
            if(height[low] > height[high]) high--;
            else low++;
        }
        return maxArea;
    }
}