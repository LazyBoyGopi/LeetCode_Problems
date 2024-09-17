class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer>map = new HashMap();

        for(String str:s1.split(" ")){
            map.put(str,map.getOrDefault(str,0)+1);
        }

        for(String str:s2.split(" ")){
            map.put(str,map.getOrDefault(str,0)+1);
        }

        List<String>list = new LinkedList();

        for(Map.Entry<String,Integer>entry : map.entrySet()){
            if(entry.getValue()==1){
                list.add(entry.getKey());
            }
        }

        String[]ans = new String[list.size()];
        int idx=0;
        for(String i:list){
            ans[idx++] = i;
        }

        return ans;
    }
}