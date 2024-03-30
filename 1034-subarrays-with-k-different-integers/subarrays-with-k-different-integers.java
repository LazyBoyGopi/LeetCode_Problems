class Solution {
    public int subarrayWithAtMostK(int[]nums,int k)
    {
        int subarrayCount = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int low = 0, high = 0;
        while (high < nums.length) {
            map.put(nums[high], map.getOrDefault(nums[high], 0) + 1);
            while (map.size() > k) {
                map.put(nums[low],map.get(nums[low])-1);
                if(map.get(nums[low]) == 0)
                {
                    map.remove(nums[low]);
                }
                low++;
            }
            subarrayCount += high - low+1;
            high++;
        }
        return subarrayCount;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        int subWithMaxK = subarrayWithAtMostK(nums, k);
        int reducedSubWithMaxK = subarrayWithAtMostK(nums, k - 1);
        return subWithMaxK - reducedSubWithMaxK;
    }
}