class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int maxBitValue = (1 << maximumBit) - 1;  // equivalent to 2^maximumBit - 1
        int len = nums.length;
        
        // Step 1: Compute cumulative XOR
        for (int i = 1; i < len; i++) {
            nums[i] ^= nums[i - 1];
        }
        
        // Step 2: Compute the results in reverse order
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = maxBitValue ^ nums[len - 1 - i];
        }
        
        return result;
    }
}
