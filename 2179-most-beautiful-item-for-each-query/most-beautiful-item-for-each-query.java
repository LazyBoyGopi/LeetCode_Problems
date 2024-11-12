class Solution {
    private int getHighestBeautyIndex(int[][]items,int price){
        int st = 0, end = items.length-1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(items[mid][0] > price) end = mid-1;
            else st = mid+1;
        }
        return end;
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items,(a,b)->Integer.compare(a[0],b[0]));
        Map<Integer,Integer>map = new HashMap();
        int max = items[0][1];
        for(int i = 0;i<items.length;i++){
            int []item = items[i];
            max = Math.max(max,item[1]);
            map.put(item[0],max);
        }
        // System.out.println(Arrays.deepToString(items));
        int[]ans = new int[queries.length];
        int i=0;
        for(int query : queries){
            int idx = getHighestBeautyIndex(items,query);
            // System.out.println(idx);
            if(idx >= 0)
                ans[i] = map.get(items[idx][0]);
            i++;
        }
        return ans;
    }
}