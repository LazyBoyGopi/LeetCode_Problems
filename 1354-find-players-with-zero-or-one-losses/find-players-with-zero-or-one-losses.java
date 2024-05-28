class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> list = new LinkedList<>();
        Map<Integer,Integer> losers = new HashMap<>();
        for(int i=0;i<matches.length;i++){
            losers.put(matches[i][1],losers.getOrDefault(matches[i][1],0)+1);
        }
        TreeSet<Integer>temp = new TreeSet<>();
        for(int i=0;i<matches.length;i++){
            if(!losers.containsKey(matches[i][0])){
                temp.add(matches[i][0]);
            }
        }
        System.out.println(temp);
        list.add(new LinkedList<>(temp));
        temp.clear();
        for(Map.Entry<Integer,Integer> entry : losers.entrySet()){
            if(entry.getValue() == 1) temp.add(entry.getKey());
        }
        list.add(new LinkedList<>(temp));
        return list;
    }
}