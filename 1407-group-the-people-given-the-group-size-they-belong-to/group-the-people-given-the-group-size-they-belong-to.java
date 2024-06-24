class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>>map = new HashMap<>();
        List<List<Integer>> groups = new LinkedList<>();

        for(int i=0;i<groupSizes.length;i++){
            int size = groupSizes[i];
            if(map.containsKey(size)){
                List<Integer> curGroup = map.get(size);
                if(curGroup.size() < size){
                    curGroup.add(i);
                }
                else{
                    groups.add(curGroup);
                    map.put(size,new LinkedList<>(Arrays.asList(i)));
                }
            }else{
                map.put(size,new LinkedList<>(Arrays.asList(i)));
            }
        }
        for(List<Integer>list : map.values()){
            groups.add(list);
        }
        return groups;
    }
}