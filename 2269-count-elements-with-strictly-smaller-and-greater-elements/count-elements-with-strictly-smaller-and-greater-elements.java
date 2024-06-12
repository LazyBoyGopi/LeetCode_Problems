class Solution {
    public int countElements(int[] nums) {
        int smallest = Integer.MAX_VALUE , greatest = Integer.MIN_VALUE;
        for(int ele : nums){
            smallest = Math.min(smallest,ele);
            greatest = Math.max(greatest,ele);
        }
        int count = 0;
        for(int ele : nums){
            if(greatest > ele && smallest < ele) count++;
        }
        return count;
    }
}