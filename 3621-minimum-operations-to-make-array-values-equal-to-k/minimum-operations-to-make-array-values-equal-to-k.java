class Solution {
    public int minOperations(int[] nums, int k) {
       int min = 101, unique = 0;
       boolean[] set = new boolean[101];
       for(int ele : nums){
        if(!set[ele]){
            set[ele] = true;
            unique++;
        }
        min = Math.min(min,ele);
        if(min < k)
            return -1;
       }
       return min == k ? unique-1 : unique;   
    }
}