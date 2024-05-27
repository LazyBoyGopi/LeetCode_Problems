class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int decreased = 0 , count = 0;
        for(int ele : nums){
            if(ele - decreased <= 0) continue;
            count++;
            decreased = ele;
        }
        return count;
    }
}