/**
class Solution {
    public int tupleSameProduct(int[] nums) {
        
        boolean[]hash = new boolean[1001];
        for(int ele : nums){
            hash[ele] = true;
        }
        int count = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int curMul = nums[i]*nums[j];
                for(int ele = 1;ele<=1000;ele++){
                    if(!hash[ele]) continue;
                    if(ele == nums[i] || ele == nums[j] || ele > curMul || curMul % ele != 0) continue;
                    int other = curMul/ele;
                    if(other == ele || other == nums[i] || other == nums[j]) continue;
                    if(hash[other]) count++;
                }
            }
        }
        return count*2;
    }
}

 */

class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer>map = new HashMap();
        int len = nums.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int mul = nums[i]*nums[j];
                map.put(mul,map.getOrDefault(mul,0)+1);
            }
        }
        int count = 0;
        for (int freq : map.values()) {
            if (freq > 1) {
                count += (freq * (freq - 1) / 2) * 8;
            }
        }
        return count;
    }
}