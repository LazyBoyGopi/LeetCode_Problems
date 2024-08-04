class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<messages.length;i++){
            int countOfSpaces = 0;
            for(int j=0;j<messages[i].length();j++){
                if(messages[i].charAt(j) ==' ') countOfSpaces++;
            }
            map.put(senders[i],map.getOrDefault(senders[i],0)+countOfSpaces+1);
        }
        List<String>list = new LinkedList<>();
        int highest = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() > highest){
                highest = entry.getValue();
                list.clear();
                list.add(entry.getKey());
            }else if(entry.getValue() == highest){
                list.add(entry.getKey());
            }
        }
        System.out.println(list+"\n"+map);
        if(list.size() == 1) return list.get(0);
        Collections.sort(list);
        return list.get(list.size()-1);
    }
}