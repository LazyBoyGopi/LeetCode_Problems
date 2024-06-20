class Solution {
    private boolean isPossible(int[]position,int m,int dis){
        int last = position[0];
        m--;
        for(int i=1;i<position.length;i++){
            if(position[i]-last>= dis) {
                m--;
                if(m == 0) return true;
                last = position[i];
            }
        }
        return m <= 0;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int st = 1 , end = position[position.length-1]-position[0];
        while(st <= end){
            int dis = st+(end-st)/2;
            if(isPossible(position,m,dis)){
                st = dis+1;
            }
            else end = dis-1;
        }
        return end;
    }
}