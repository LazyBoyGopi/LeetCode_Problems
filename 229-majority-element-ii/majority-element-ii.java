class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int three = (nums.length/3)+1;
        List<Integer>list = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums)
        {
            map.put(ele,map.getOrDefault(ele,0)+1);
            if(map.get(ele) == three) list.add(ele);
        }
        return list;
    }
}