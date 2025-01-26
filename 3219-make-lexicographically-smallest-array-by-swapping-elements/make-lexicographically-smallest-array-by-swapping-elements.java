class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int len = nums.length;
        int[][]copySorted = new int[len][2];
        for(int i=0;i<len;i++){
            copySorted[i] = new int[]{nums[i],i};
        }
        Arrays.sort(copySorted,(a,b)->a[0]-b[0]);
        int l = 0, r = 1;
        while(r < len){
            List<Integer>sortedIndexes = new ArrayList();
            sortedIndexes.add(copySorted[l][1]);
            while(r < len && Math.abs(copySorted[r-1][0]-copySorted[r][0]) <= limit){
                sortedIndexes.add(copySorted[r++][1]);
            }
            Collections.sort(sortedIndexes);
            int sLen = sortedIndexes.size();
            for(int i=0;i<sLen;i++){
                nums[sortedIndexes.get(i)] = copySorted[i+l][0];
            }
            l = r;
            r++;

        }
        return nums;
    }
}