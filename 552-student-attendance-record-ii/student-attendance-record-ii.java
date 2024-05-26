class Solution {
    private static int MOD = 1000000007;
    private int backTrack(int idx,int n,int absent,int lateCount,int[][][]temp){
        if(n == idx) {
            return 1;
        }
        int num = temp[idx][absent][lateCount];
        if(num != -1) return num;
        int with_a_next = (absent == 0) ? backTrack(idx+1,n,absent+1,0,temp) : 0;
        int with_l_next = (lateCount == 2) ? 0 : backTrack(idx+1,n,absent,lateCount+1,temp);
        int with_p_next = backTrack(idx+1,n,absent,0,temp);
        int total = (((with_a_next + with_l_next) % MOD)+with_p_next)%MOD;
        return temp[idx][absent][lateCount] = total;
    }
    public int checkRecord(int n) {

        int[][][]temp = new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    temp[i][j][k] = -1;
                }
            }
        }
        return backTrack(0,n,0,0,temp);
    }
}