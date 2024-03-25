class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        for(int i : nums)
        {
            if(set.contains(i)) list.add(i);
            else set.add(i);
        }
        return list;
    }
}