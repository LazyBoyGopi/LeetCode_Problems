class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        List<int[]>copy = new ArrayList<int[]>(n);
        for(int i=0;i<n;i++){
            copy.add(new int[]{nums[i],i});
        }
        copy.sort(Comparator.comparingInt(a->a[0]));

        int l = 0, r = 1;
        while(r < n){
            List<Integer>pos = new ArrayList<Integer>();
            pos.add(copy.get(l)[1]);
            while(r < n && Math.abs(copy.get(r-1)[0] - copy.get(r)[0]) <= limit){
                pos.add(copy.get(r++)[1]);
            }
            Collections.sort(pos);
            for(int i=0;i<pos.size();i++){
                nums[pos.get(i)] = copy.get(l++)[0];
            }
            r++;
        }
        return nums;
    }
}