class Solution {
    public int minOperations(int[] nums, int k) {
       int min = 101;
       Set<Integer>set = new HashSet();
       for(int ele : nums){
        set.add(ele);
        min = Math.min(min,ele);
       }
       if(min < k) return -1;
       return min == k ? set.size()-1 : set.size();
       
    }
}