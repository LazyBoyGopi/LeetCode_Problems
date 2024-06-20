class Solution {
    private boolean isPossible(int[]position,int m,long dis){
        int last = 0;
        for(int i=1;i<position.length;i++){
            if(Math.abs(position[last]-position[i]) >= dis) {
                m--;
                if(m-1 == 0) return true;
                last = i;
            }
        }
        return m-1 <= 0;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        long st = 1 , end = position[position.length-1]-position[0];
        while(st <= end){
            long dis = st+(end-st)/2;
            if(isPossible(position,m,dis)){
                st = dis+1;
            }
            else end = dis-1;
        }
        return (int)end;
    }
}