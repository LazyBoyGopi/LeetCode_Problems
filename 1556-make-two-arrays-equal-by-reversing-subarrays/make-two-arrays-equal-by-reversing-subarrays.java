class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int ele : target) map.put(ele,map.getOrDefault(ele,0)+1);
        for(int ele : arr){
            int times = map.containsKey(ele) ? map.get(ele) : 0;
            times--;
            map.put(ele,times);
        }
        for(int value : map.values()) if(value != 0) return false;
        return true;
    }
}