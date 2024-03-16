class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = 0 , count = 0;
        for(int apples : apple) sum += apples;
        for(int i=capacity.length-1;i>=0;i--)
        {
            sum -= capacity[i];
            count++;
            if(sum <= 0) return count;
        }
        return -1;
    }
}