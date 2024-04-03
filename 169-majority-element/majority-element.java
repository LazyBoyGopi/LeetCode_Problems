class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer>map = new HashMap<>();
        for(int ele : nums)
        {
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        int max = 0 , ele = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                ele = entry.getKey();
            }
        }
        return ele;
    }
}