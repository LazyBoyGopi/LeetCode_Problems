class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=1;i<nums.length;i++){
            nums[i] += nums[i-1];
        }
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<queries.length;i++){
            int st = 0 , end = n-1;
            while(st <= end){
                int mid = st+(end-st)/2;
                if(nums[mid] <= queries[i]) st = mid+1;
                else end = mid-1;
            }
            queries[i] = st;
        }
        return queries;
    }
}