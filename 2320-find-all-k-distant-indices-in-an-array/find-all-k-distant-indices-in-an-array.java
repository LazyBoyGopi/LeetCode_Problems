class Solution {
    private void getCombinations(int findTarget,int[]nums,int k,Set<Integer>set)
    {
        for(int i=0;i< nums.length;i++)
        {
            if(Math.abs(findTarget-i) <= k) {
                set.add(i);
            }
        }
    }
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> set = new HashSet<>();
        int cur = 0 , findTarget = 0 , nextIdx = 0;
        while(findTarget < nums.length)
        {
            if(nums[findTarget] == key)
            {
               getCombinations(findTarget,nums,k,set); 
            }
            findTarget++;
        }
        LinkedList list = new LinkedList<>(set);
        Collections.sort(list);
        return list;
    }
}