class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int len = nums.length;
        int[][]sortedCopy = new int[len][2];
        for(int i=0;i<len;i++){
            sortedCopy[i] = new int[]{nums[i],i};
        }
        Arrays.sort(sortedCopy,(a,b)->a[0]-b[0]);

        int left = 0, right = 1;
        while(right < len){
            List<Integer> positions = new ArrayList();
            positions.add(sortedCopy[left][1]);
            while(right < len && Math.abs(sortedCopy[right][0] - sortedCopy[right-1][0]) <= limit){
                positions.add(sortedCopy[right++][1]);
            }

            Collections.sort(positions);
            for(int i=0;i<positions.size();i++){
                nums[positions.get(i)] = sortedCopy[left++][0];
            }
            right++;
        }
        return nums;
    }
}