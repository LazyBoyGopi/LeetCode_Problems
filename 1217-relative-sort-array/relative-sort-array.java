class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer>map = new HashMap<>();
        int idx = 0;
        for(int ele : arr1) map.put(ele,map.getOrDefault(ele,0)+1);

        for(int ele : arr2){
            if(map.containsKey(ele)){
                int repeatedTimes = map.get(ele);
                while(repeatedTimes > 0){
                    arr1[idx++] = ele;
                    repeatedTimes--;
                }
                map.remove(ele);
            }
        }
        List<Integer>list = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int val = entry.getKey();
            int times = entry.getValue();
            while(times > 0){
                list.add(val);
                times--;
            }
        }
        Collections.sort(list);
        for(int ele : list){
            arr1[idx++] = ele;
        }
        return arr1;
    }
}