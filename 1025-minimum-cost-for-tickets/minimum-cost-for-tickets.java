class Solution {

    private int oneDay,sevenDays,thirtyDays;

    private int binarySearch(int[]days,int st,int target){
        int end = days.length-1;
        while(st <= end){
            int mid = st+(end-st)/2;
            int ele = days[mid];
            if(ele == target) return mid;
            if(ele > target) end = mid-1;
            else st = mid+1;
        }
        return end;
    }

    private int getAllCombinations(int[]days,int idx,int[]dp){
        int len = days.length;

        if(idx >= len){
            return 0;
        }

        if(dp[idx] != -1 ) return dp[idx];

        int curDays = days[idx];
        int sevenAdded = curDays + 6;
        int thirtyAdded = curDays + 29;

        int sevenIdx = binarySearch(days,idx,sevenAdded);
        int thirtyIdx = binarySearch(days,idx,thirtyAdded);


        int one = oneDay+getAllCombinations(days,idx+1,dp);
        int seven = sevenDays+getAllCombinations(days,sevenIdx+1,dp);
        int thirty = thirtyDays+getAllCombinations(days,thirtyIdx+1,dp);

        
        return dp[idx] = Math.min(one,Math.min(seven,thirty));
    }

    public int mincostTickets(int[] days, int[] costs) {
        oneDay = costs[0];
        sevenDays = costs[1];
        thirtyDays = costs[2];
        int[]dp = new int[days.length+1];
        Arrays.fill(dp,-1);
        return getAllCombinations(days,0,dp);
    }
}