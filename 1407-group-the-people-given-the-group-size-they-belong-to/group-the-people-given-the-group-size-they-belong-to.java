class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<List<Integer>>>map = new HashMap<>();
        for(int i=0;i<groupSizes.length;i++){
            int size = groupSizes[i];
            if(map.containsKey(size)){
                List<List<Integer>> curGroup = map.get(size);
                boolean added = false;
                for(List<Integer>list : curGroup){
                    if(list.size() < size){
                        list.add(i);
                        added = true;
                    }
                }
                if(!added){
                    map.get(size).add(new LinkedList<>(Arrays.asList(i)));
                }
            }else{
                List<List<Integer>>list = new LinkedList<>();
                list.add(new LinkedList<>(Arrays.asList(i)));
                map.put(size,list);
            }
        }
        List<List<Integer>> groups = new LinkedList<>();
        for(List<List<Integer>> allList : map.values()){
            for(List<Integer> list : allList){
                groups.add(list);
            }
        }
        return groups;
    }
}