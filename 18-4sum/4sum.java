class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList();
        Arrays.sort(nums);
        int i=0, len = nums.length;
        while(i < len){
            int j=i+1;
            while(j < len){
                int k = j+1, l = len-1;
                while(k < l){
                    long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum == target){

                        List<Integer> list = new LinkedList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        result.add(list);

                        int temp = nums[k];
                        while(k < len && nums[k] == temp) k++;
                        temp = nums[l];
                        while(l > j && nums[l] == temp) l--;
                    }else if(sum > target) l--;
                    else k++;
                }
                int temp = nums[j];
                while(j < len && temp == nums[j]) j++;
            }
            int temp = nums[i];
            while(i < len && temp == nums[i]) i++;
        }
        return result;
    }
}