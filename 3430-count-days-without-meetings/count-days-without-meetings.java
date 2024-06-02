class Solution {
    public int countDays(int days, int[][] meetings) {
       Arrays.sort(meetings,(a,b) -> Integer.compare(a[0],b[0]));
       int last = meetings[0][0] ,count = 0;
       count += meetings[0][0] != 1 ? meetings[0][0]-1 : 0;
       for(int i=0;i<meetings.length;i++){
            int ar[] = new int[2];
            ar[0] = meetings[i][0];
            ar[1] = meetings[i][1];
            int j;
            for(j=i+1;j<meetings.length;j++){
                if(meetings[j][0] <= ar[1])
                    ar[1] = Math.max( meetings[j][1],ar[1]);
                else 
                    break;
            }
            i=j-1;
            count += (ar[0]-last-1) > 0 ? ar[0]-last-1 : 0;
            last = ar[1];
       } 
        count += (days != last) ? days-last : 0;
        return count;  
    }
}