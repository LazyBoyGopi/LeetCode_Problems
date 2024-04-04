class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] ar) {
        Arrays.sort(ar);
        if(ar.length == 1) return 1;
        int max = 0;
        ar[0] =1;
        for(int i=1;i<ar.length;i++)
        {
            if(!(Math.abs(ar[i]-ar[i-1]) <= 1))
            {
                ar[i] = ar[i-1]+1;
            }
            max = Math.max(max,ar[i]);
        }
        return max;
    }
}