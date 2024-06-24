class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int validFlipFromPastWindow = 0 , flipCount = 0 , len = nums.length;
        boolean flipped [] = new boolean[len];
        for(int i=0;i<k;i++){
            if((validFlipFromPastWindow% 2 == 0 && nums[i] == 0) || (validFlipFromPastWindow% 2 == 1 && nums[i] == 1)){
                if(i+k > len) return -1;
                flipped[i] = true;
                validFlipFromPastWindow++;
                flipCount++;
            }
        }
        for(int i=k;i<len;i++){
            if(flipped[i-k]) validFlipFromPastWindow--;
            if(validFlipFromPastWindow % 2 == 0 && nums[i] == 0 || validFlipFromPastWindow% 2 == 1 && nums[i] == 1){
                if(i+k > len) return -1;
                flipCount++;
                validFlipFromPastWindow++;
                flipped[i] = true;
            }
        }
        return flipCount;
       /* int left = 0 , flips = 0 , len = nums.length , nextStart = -1;
        while(left < len){
            if(nums[left] == 1) {
                left++;
                continue;
            }
            nextStart = -1;
            if(left + k > len) return -1;
            boolean start = true;
            for(int i=left;i<left+k;i++){
                if(start && nums[i] == 0) continue;
                else{
                    if(start) {
                        nextStart = i;
                        start = false;
                    }
                    if(nums[i] == 0) nums[i] = 1;
                    else nums[i] = 0;
                }
            }
            flips++;
            left = nextStart != -1 ? nextStart : left + k;
        }
        return flips; */
    }
}