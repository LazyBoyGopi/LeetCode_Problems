class Solution {
    private int getHighestBeauty(int[][]items,int price){
        int st = 0, end = items.length-1, max = 0;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(items[mid][0] > price) end = mid-1;
            else {
                max = Math.max(max,items[mid][1]);
                st = mid+1;
            }
        }
        return max;
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items,(a,b)->Integer.compare(a[0],b[0]));
        int max = items[0][1];
        for(int[]item : items){
            max = Math.max(max,item[1]);
            item[1] = max;
        }
        int[]ans = new int[queries.length];
        int i=0;
        for(int query : queries){
            ans[i++] = getHighestBeauty(items,query);
        }
        return ans;
    }
}