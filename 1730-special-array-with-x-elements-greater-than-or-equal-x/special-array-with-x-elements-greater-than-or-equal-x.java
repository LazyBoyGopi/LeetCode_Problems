class Solution {
    public int specialArray(int[] nums) {
        int largest = Integer.MIN_VALUE;
        for(int ele : nums) if(ele > largest) largest = ele;
        int i;
        for(i=largest;i>=0;i--){
            int count = 0;
            for(int ele : nums){
                if(ele >= i) count++;
            }
            if(i != 0 && count == i) return i;
        }
        return i;
    }
}