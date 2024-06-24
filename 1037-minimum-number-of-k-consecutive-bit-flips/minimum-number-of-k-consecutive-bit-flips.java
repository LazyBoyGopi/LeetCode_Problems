class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int len = nums.length , flipCount = 0 , validFilpsInLastWindow = 0;
        boolean[] flipped = new boolean[len];
        for(int i=0;i<len;i++){
            if(i >= k){
                if(flipped[i-k]) validFilpsInLastWindow--;
            }
            if(validFilpsInLastWindow % 2 == nums[i]){
                if(i+k > len) return -1;
                validFilpsInLastWindow++;
                flipCount++;
                flipped[i] = true;
            }
        }
        return flipCount;
    }
}