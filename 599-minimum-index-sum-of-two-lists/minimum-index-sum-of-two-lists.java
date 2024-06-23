class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<Integer,List<String>>map = new HashMap<>();
        for(int i=0;i<list1.length;i++){
            String str = list1[i];
            for(int j=0;j<list2.length;j++){
                if(str.equals(list2[j])){
                    if(map.containsKey(i+j)){
                        map.get(i+j).add(str);
                    }else{
                        map.put(i+j,new LinkedList(Arrays.asList(str)));
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(Integer key : map.keySet()){
            min = Math.min(min,key);
        }
        List<String>list = map.get(min);
        String[]ans = new String[list.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}