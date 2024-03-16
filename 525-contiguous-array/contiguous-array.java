class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0 , maxLen = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == 1) sum++;
            else sum--;
            if(sum == 0)
            {
                maxLen = i+1;
            }
            else if(map.containsKey(sum))
            {
                maxLen = Math.max(maxLen,i-map.get(sum));
            }
            else{
                map.put(sum,i);
            }
        }
        return maxLen;
        // int zeroCount = 0 , oneCount = 0 , maxLen = 0;
        // System.out.println(nums.length);
        // for(int i=0;i<nums.length;i++)
        // {
        // zeroCount = 0;
        // oneCount = 0;
        // for(int j=i;j<nums.length;j++)
        // {
        // if(nums[j] == 0) zeroCount++;
        // else oneCount++;
        // if(oneCount == zeroCount)
        // {
        // maxLen = Math.max(maxLen,oneCount*2);
        // }
        // }
        // }
        // return maxLen;
    }
}