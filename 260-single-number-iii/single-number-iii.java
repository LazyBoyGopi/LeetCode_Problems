class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int ele : nums) xor ^= ele;
        int lowestBit = xor & (-xor);
        int ar[] = new int[2];
        for(int ele : nums){
            if((ele & lowestBit) == 0) ar[0] ^= ele;
            else ar[1] ^= ele;
        }
        return ar;
    }
}