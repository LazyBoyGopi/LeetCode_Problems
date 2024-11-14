class Solution {
    private int[] getMinAndMax(int[]quantities){
        int max = quantities[0], min = max;
        for(int ele : quantities) {
            max = Math.max(max,ele);
            min = Math.min(min,ele);
        }
        return new int[]{min,max};
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
        int[] minAndMax = getMinAndMax(quantities); 
        int st = 1, end = minAndMax[1], ans = end;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(isPossible(mid,n,quantities)){
                ans = Math.min(ans,mid);
                end = mid-1;
            }else 
            {
                st = mid+1;
            }
        }
        return ans;
    }
}