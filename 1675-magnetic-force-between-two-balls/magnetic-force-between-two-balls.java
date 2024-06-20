class Solution {
    private boolean isPossible(int[]position,int m,int day){
        m--;
        int last = position[0];
        for(int i=1;i<position.length;i++){
            if(position[i]-last >= day) {
                last = position[i];
                m--;
                if(m <= 0) return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int len = position.length, st = 1 , end = position[len-1]-position[0];
        while(st <= end){
            int day = st+(end-st)/2;
            if(isPossible(position,m,day)) st = day+1;
            else
                end = day-1;
        }
        return end;
    }
}