class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer,Integer>map = new HashMap<>();
        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        List<Integer>list = new LinkedList<>();
        for(Map.Entry<Integer,Integer>entry : map.entrySet()){
            int val = entry.getValue();
            int key = entry.getKey();
            if(val == 1 && !map.containsKey(key+1) && !map.containsKey(key-1)){
                list.add(key);
            }
        }
        return list;
    }
}