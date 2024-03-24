class Solution {
    public int findDuplicate(int[] nums) {
        boolean freq[] = new boolean[nums.length];
        for(int ele : nums) {
            if(freq[ele]) return ele;
            freq[ele] = true;
        }
        return 0;
    }
}