class Solution {
    public int countElements(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            boolean smaller = false , bigger = false;
           for(int j=0;j<nums.length;j++){
                if(nums[i] > nums[j]){
                    smaller = true;
                }
                if(nums[i] < nums[j]){
                    bigger = true;
                }
                if(bigger && smaller) break;
           }
           if(smaller && bigger) count++;
        }
        return count;
    }
}