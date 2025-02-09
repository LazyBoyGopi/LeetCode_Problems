/**
Brute Force
class Solution {
    public long countBadPairs(int[] nums) {
        long badPairs = 0l;
        int len = nums.length, curIEle = -1;
        for(int i=0;i<len;i++){
            curIEle = nums[i];
            for(int j=i+1;j<len;j++){
                if(nums[j]-curIEle != j-i)
                    badPairs++;
            }
        }
        return badPairs;
    }
}
 */

class Solution {
    public long countBadPairs(int[] nums) {
        long goodPairs =0l;
        int len = nums.length;
        Map<Long,Long>map = new HashMap();
        for(int i=0;i<len;i++){
            long ele = i-nums[i];
            map.put(ele,map.getOrDefault(ele,0l)+1);
        }
        for(long value : map.values()){
            goodPairs += (value)*(value-1)/2;
        }
        return (((long)len)*(len-1)/2) - goodPairs;
    }
}