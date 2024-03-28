class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxLen = 0 , len = nums.length , first = 0 , second = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(first < len && second < len)
        {
            int ele = nums[second];
            if(map.containsKey(ele))
            {
                if(map.get(ele) < k)
                {
                    map.put(ele,map.get(ele)+1);
                    maxLen = Math.max(maxLen,second-first+1);
                    second++;
                }
                else{
                    map.put(nums[first],map.get(nums[first])-1);
                    first++;
                    continue;
                }
            }
            else {
                map.put(ele,1);
                maxLen = Math.max(maxLen,second-first+1);
                second++;
            }
        }
        return maxLen;
    }
}