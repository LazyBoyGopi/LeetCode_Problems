class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean []check = new boolean[1001];
        for(int ele : nums) check[ele] = true;

        while(original <= 1000 && check[original]) original *=2;
        return original;
    }
}