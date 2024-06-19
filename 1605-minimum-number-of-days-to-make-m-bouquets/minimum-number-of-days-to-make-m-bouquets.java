class Solution {
    private boolean isPossible(int[]bloomDay,int m,int k,int mid){
        int count = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i] - mid <= 0){ 
                count++;
            }
            else{
                count = 0;
            }
            if(count == k) {
                count = 0;
                m--;
                if(m == 0) return true;
            }
        }
        return m <= 0;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (m*k)) return -1;
        int st = 0 , end = 0;
        for(int ele : bloomDay) end = Math.max(end,ele);
        int max = end;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(isPossible(bloomDay,m,k,mid)) end = mid-1;
            else st = mid+1;
        }
        return end ==max ? -1 : st;
    }
}