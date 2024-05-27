class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0 , decreased = 0;
        for(int ele : nums){
            if(ele-decreased <= 0) continue;
            count++;
            decreased += (ele-decreased);
        }
        return count;
    }
}