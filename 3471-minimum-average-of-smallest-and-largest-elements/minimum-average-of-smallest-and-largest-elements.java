class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double smallest = 100;
        int half = nums.length/2 , len = nums.length;
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<=half;i++){
            smallest = Math.min(smallest,nums[i]+nums[len-i-1]);
        }
        return (double)smallest/2.0;
    }
}