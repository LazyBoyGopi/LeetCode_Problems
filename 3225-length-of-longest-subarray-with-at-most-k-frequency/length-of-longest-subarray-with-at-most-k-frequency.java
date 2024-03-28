class Solution {
    private boolean getFreq(int[] nums, int st, int end, int ele, int k) {
        int count = 0;
        for (int i = st; i <= end; i++) {
            if (nums[i] == ele)
                count++;
            if (count > k)
                return false;
        }
        return true;
    }

    private boolean isPossible(int[] nums, int st, int end, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = st; i <= end; i++) {
            if (set.contains(nums[i]))
                continue;
            else {
                set.add(nums[i]);
                if (!getFreq(nums, st, end, nums[i], k))
                    return false;
            }
        }
        return true;
    }

    public int maxSubarrayLength(int[] nums, int k) {
        int maxLen = 0 , len = nums.length , first = 0 , second = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(first < len && second < len)
        {
            int ele = nums[second];
            // System.out.println(first +" "+ second+" "+ map);
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
        // for (int i = 0; i < nums.length; i++) {
        //     Map<Integer, Integer> map = new HashMap<>();
        //     for (int j = i; j < nums.length; j++) {
        //         if (map.containsKey(nums[j])) {
        //             if (map.get(nums[j]) < k)
        //                 map.put(nums[j], map.get(nums[j]) + 1);
        //             else
        //                 break;
        //         } else {
        //             map.put(nums[j], 1);
        //         }
        //         maxLen = Math.max(maxLen, j - i + 1);
        //     }
        //     if (maxLen == nums.length)
        //         return nums.length;
        // }
        // return maxLen;
    }
}