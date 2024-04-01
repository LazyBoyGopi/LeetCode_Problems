class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = 0;
        for(int ele : left)
        {
            if(ele == n) return n;
            max = Math.max(max,n-(n-ele));
        }
        for(int ele : right)
        {
            if(ele == 0) return n;
            max = Math.max(max,n-ele);
        }
        return max;
    }
}