class Solution {
    public List<String> stringMatching(String[] words) {
        List<String>list = new ArrayList();
        int len = words.length;
        for(int i=0;i<len;i++){
            String cur = words[i];
            for(int j=0;j<len;j++){
                String jStr = words[j];
                if(i== j || jStr.length() < cur.length()) continue;
                if(jStr.contains(cur)){
                    list.add(cur);
                    break;
                }
            }
        }
        return list;
    }
}