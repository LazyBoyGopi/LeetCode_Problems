class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long ans = 0l;
        int negativeNumbersCount = 0;
        boolean isZero = false;
        int smallest = Integer.MAX_VALUE;
        for(int [] ar : matrix){
            for(int ele : ar){
                if(ele == 0) isZero = true;
                if(ele < 0) {
                    negativeNumbersCount++;
                    ele *= -1;
                }
                smallest = Math.min(smallest,ele);
                ans += ele;
            }
        }
        if(!isZero && (negativeNumbersCount % 2 == 1)){
            ans -= (2*smallest);
        }
        return ans;
    }
}