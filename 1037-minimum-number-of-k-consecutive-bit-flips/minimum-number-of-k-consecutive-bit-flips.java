class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int flipCount = 0 , len = nums.length , validFlipsFromLastWindow = 0;
        Deque<Boolean>flipped = new LinkedList<>();
        for(int i=0;i<len;i++){
            if(i >= k){
                if(flipped.poll()) validFlipsFromLastWindow--;
            }
            if(validFlipsFromLastWindow %2 == nums[i]){
                if(i+k > len) return -1;
                validFlipsFromLastWindow++;
                flipped.addLast(true);
                flipCount++;
            }
            else{
                flipped.offer(false);
            }
        }
        return flipCount;
    }
}