class Solution {
    private int getLongestForCurrentEle(Set<Integer>set,long curEle){
        int longest = 1;
        curEle *= curEle;
        while(curEle <= Math.pow(10,5) && set.contains((int)curEle)){
            curEle *= curEle;
            longest++;
        }
        return longest == 1 ? 0 : longest;
    }
    public int longestSquareStreak(int[] nums) {
        int longestStreak = 0, half = (nums.length+1)/2;
        HashSet<Integer> set = new HashSet();
        for(int ele : nums){
            set.add(ele);
        }
        for(int ele : nums){
            longestStreak = Math.max(longestStreak,getLongestForCurrentEle(set,(long)ele));
            if(longestStreak == 5) return 5;
        }
        return longestStreak == 0 ? -1 : longestStreak;
    }
}