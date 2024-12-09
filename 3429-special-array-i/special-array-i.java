class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean isEven = nums[0] % 2 == 0;
        int len = nums.length;;
        for(int i=1;i<len;i++){
            if(isEven && nums[i]%2 == 0){
                return false;
            }
            else if(!isEven && nums[i]% 2 == 1) return false;
            isEven = !isEven;
        }
        return true;
    }
}