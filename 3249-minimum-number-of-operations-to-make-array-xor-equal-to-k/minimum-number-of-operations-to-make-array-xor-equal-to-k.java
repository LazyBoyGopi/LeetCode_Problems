class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for(int ele : nums) xor ^= ele;
        int count = 0;
        while(k > 0 || xor > 0)
        {
            if(k%2 != xor%2) count++;
            k /=2;
            xor /=2;
        }
        return count;
    }
}