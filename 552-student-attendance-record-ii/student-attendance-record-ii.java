class Solution {
    private static final int MOD = 1000000007;
    private int backTrack(int n,int[][][]temp,int count_a,int count_l,int cur_idx){
        if(cur_idx == n) return 1;
        if(temp[cur_idx][count_l][count_a] != -1) return temp[cur_idx][count_l][count_a];

        int with_a_next = (count_a == 0) ? backTrack(n,temp,count_a+1,0,cur_idx+1) : 0;
        int with_l_next = (count_l == 2) ? 0 : backTrack(n,temp,count_a,count_l+1,cur_idx+1);
        int with_p_next = backTrack(n,temp,count_a,0,cur_idx+1);
        int total = (((with_a_next + with_l_next) % MOD )+with_p_next) %MOD;
        return temp[cur_idx][count_l][count_a] = total;  
    }
    public int checkRecord(int n) {
        int[][][] temp = new int[n][3][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<2;k++){
                    temp[i][j][k] = -1;
                }
            }
        }
        return backTrack(n,temp,0,0,0);
    }
}