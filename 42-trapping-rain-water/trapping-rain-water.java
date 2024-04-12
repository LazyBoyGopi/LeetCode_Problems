class Solution {
    public int trap(int[] height) {
        int low = 0 , high = 0;
        int totalWater = 0 ;
        outer : while(high < height.length)
        {
            int cur = high+1 , curMax = Integer.MIN_VALUE , maxIdx = high;

            while(cur < height.length && curMax < height[high])
            {
                if(height[cur] > curMax)
                {
                    curMax = height[cur];
                    maxIdx = cur;
                }
                cur++;
            }
            cur--;
            curMax = Math.min(curMax,height[high]);
            while(high < maxIdx)
            {
                totalWater += curMax-height[high] <= 0 ? 0 : curMax-height[high];
                high++;
                if(high == maxIdx) {
                    continue outer;
                }
            }
            high++;
            // int cur = high+1;
            // int water = 0;
            // while(cur < height.length && height[cur] < height[high])
            // {
            //     water += height[high] - height[cur];
            //     cur++;
            // }
            // if(cur != height.length)
            // {
            //     totalWater += water;
            //     high = cur;
            // }
            // else
            // high++;
        }
        return totalWater;
    }
}