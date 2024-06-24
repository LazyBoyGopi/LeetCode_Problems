class Solution {
    public int minOperations(int[] nums) {
        int len = nums.length , flipCount = 0 , numOfFlips =0;
        Deque<Boolean> flipped = new LinkedList<>();
        for(int i=0;i<len;i++){
            if(i >= 3 && flipped.poll()) numOfFlips--;
            if(numOfFlips%2 == nums[i]){
                if(i+3 > len) return -1;
                numOfFlips++;
                flipCount++;
                flipped.offer(true);
            }
            else{
                flipped.offer(false);
            }
        }
        return flipCount;
    }
}