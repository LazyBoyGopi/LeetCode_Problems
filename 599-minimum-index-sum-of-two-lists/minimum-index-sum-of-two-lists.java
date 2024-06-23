class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String>idx = new LinkedList<>();
        int min = 2000;
        Map<String,Integer>map  = new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        for(int i=0;i<list2.length;i++){
            String str = list2[i];
            if(map.containsKey(str)){
                int sum = map.get(str)+i;
                if(sum < min){
                    min = sum;
                    idx.clear();
                    idx.add(str);
                }else if(min == sum){
                    idx.add(str);
                }
            }
        }
        return idx.toArray(new String[idx.size()]);
    }
}