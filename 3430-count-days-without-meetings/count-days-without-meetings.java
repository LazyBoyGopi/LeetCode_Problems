class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            return a[0]-b[0];
        });
        int len = meetings.length;
        int totalAvailableDays = 0;
        totalAvailableDays += meetings[0][0]-1;
        int right = meetings[0][1];
        for(int i=1;i<len;i++){
            int[]meeting = meetings[i];
            int curStartDate = meeting[0], curEndDate = meeting[1];
            if(curStartDate <= right){
                right = Math.max(right,curEndDate);
            }
            else{
                totalAvailableDays += (curStartDate-right-1);
                right = curEndDate;
            }
        }
        totalAvailableDays += (days-right);
        return totalAvailableDays;
    }
}