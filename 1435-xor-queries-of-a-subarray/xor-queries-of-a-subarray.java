class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[]answer = new int[queries.length];
        int[]xor = new int[arr.length];
        xor[0] = arr[0];

        for(int i=1;i<arr.length;i++){
            xor[i] = xor[i-1] ^ arr[i];
        }

        for(int i=0;i<queries.length;i++){
            int st = queries[i][0];
            int end = queries[i][1];

            if(st == end) answer[i] = arr[st];
            else if(st == 0) answer[i] = xor[end];
            else{
                answer[i] = xor[end] ^ xor[st-1];
            }
        }

        return answer;
    }
}