class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int three = nums.length/3;
        Set<Integer>set = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums)
        {
            map.put(ele,map.getOrDefault(ele,0)+1);
            if(map.get(ele) > three) set.add(ele);
        }
        return new LinkedList<>(set);
    }
}