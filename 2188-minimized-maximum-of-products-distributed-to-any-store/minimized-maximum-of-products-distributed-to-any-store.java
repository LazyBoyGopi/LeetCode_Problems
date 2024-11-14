class Solution {
    private int getMax(int[]quantities){
        int max = quantities[0];
        for(int ele : quantities) {
            max = Math.max(max,ele);
        }
        return max;
    }
    private boolean isPossible(int mid,int n,int[]quantities){
        int numberOfStores = 0, len = quantities.length;
        for(int i=0;i<len;i++){
            int quantity = quantities[i];
            numberOfStores += quantity/mid;
            if(quantity % mid != 0){
                numberOfStores++;
            }
        }
        return numberOfStores <= n;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int st = 1, end = getMax(quantities);
        while(st <= end){
            int mid = st+(end-st)/2;
            if(isPossible(mid,n,quantities)){
                end = mid-1;
            }
            else {
                st = mid+1;
            }
        }
        return st;
    }
}