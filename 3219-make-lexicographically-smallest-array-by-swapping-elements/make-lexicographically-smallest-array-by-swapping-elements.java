class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int len = nums.length;
        List<int[]>copySorted = new ArrayList<>();
        for(int i=0;i<len;i++){
            copySorted.add(new int[]{nums[i],i});
        }
        copySorted.sort(Comparator.comparingInt(a->a[0]));
        int l = 0, r = 1;
        while(r < len){
            List<Integer>sortedIndexes = new ArrayList();
            sortedIndexes.add(copySorted.get(l)[1]);
            while(r < len && Math.abs(copySorted.get(r)[0]-copySorted.get(r-1)[0]) <= limit){
                sortedIndexes.add(copySorted.get(r++)[1]);
            }
            Collections.sort(sortedIndexes);
            for(int i=0;i<r-l;i++){
                nums[sortedIndexes.get(i)] = copySorted.get(i+l)[0];
            }
            l = r;
            r++;

        }
        return nums;
    }
}