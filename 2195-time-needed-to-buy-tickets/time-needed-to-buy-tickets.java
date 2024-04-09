class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int target = tickets[k] , time = 0;
        for(int i=0;i<tickets.length;i++)
        {
            int ele = tickets[i];
            time += ele-target < 0 ? ele : target;
            if(i > k && ele >= target) time--;
        }
        return time;
    }
}