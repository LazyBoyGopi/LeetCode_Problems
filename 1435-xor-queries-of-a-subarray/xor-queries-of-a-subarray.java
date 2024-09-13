class Solution {
    private int getXOROf(int st,int end,int[]arr){
        int xor =0;
        for(int i=st;i<=end;i++){
            xor ^= arr[i];
        }
        return xor;
    }
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[]answer = new int[queries.length];
        int idx = 0;
        for(int []query : queries){
            answer[idx++] = getXOROf(query[0],query[1],arr);
        }
        return answer;
    }
}