class Solution {
    private long getSum(int[]nums)
    {
        long sum = 0;
        for(int ele : nums) sum += ele;
        return sum;
    }
    private boolean isPalindrome(int num)
    {
        if(num < 10) return true;
        String str = Integer.toString(num);
        int len = str.length();
        for(int i=0;i<len/2;i++)
        {
            if(str.charAt(i) != str.charAt(len-i-1)) return false;;
        }
        return true;
    }
    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        int avg = nums[nums.length/2];
        boolean isAvgPalindrome = false , isAvg1Palindrome = false;
        int avg1 = avg;
        while(!isAvgPalindrome)
        {
            if(isPalindrome(avg))
            {
                isAvgPalindrome = true;
            }
            else avg--;
        }
        while(!isAvg1Palindrome)
        {
            if(isPalindrome(avg1))
            {
                isAvg1Palindrome = true;
            }
            else avg1++;
        }
        System.out.println(avg+" "+avg1);
        long total = 0L , total1 = 0L;
        for(int ele : nums)
        {
            total1 += Math.abs(ele-avg);
            total += Math.abs(ele-avg1);
        }
        return Math.min(total,total1);
    }
}