class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer>map = new HashMap();
        Map<String,Integer>map2 = new HashMap();

        for(String str:s1.split(" ")){
            map.put(str,map.getOrDefault(str,0)+1);
        }

        for(String str:s2.split(" ")){
            map2.put(str,map2.getOrDefault(str,0)+1);
        }

        Set<String>list = new HashSet();

        for(Map.Entry<String,Integer>entry : map.entrySet()){
            if(entry.getValue()==1 && !map2.containsKey(entry.getKey())){
                list.add(entry.getKey());
            }
        }
        
        for(Map.Entry<String,Integer>entry : map2.entrySet()){
            if(entry.getValue()==1 && !map.containsKey(entry.getKey())){
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