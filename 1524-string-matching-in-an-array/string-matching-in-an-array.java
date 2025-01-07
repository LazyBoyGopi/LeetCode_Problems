class Solution {
    private boolean contains(String first,String second){
        int p1 = 0, p2 = 0,l1 = first.length(), l2 = second.length();
        if(l1 > l2) return false;
        boolean isFirst = false;
        int lastEqual = -1;
        while(p1 < l1 && p2 < l2){
            if(first.charAt(p1) == second.charAt(p2)){
                p1++;
                if(!isFirst){
                    isFirst = true;
                    lastEqual = p2;
                }
                p2++;
            }else{
                p1 = 0;
                if(lastEqual != -1) {
                    p2 = lastEqual+1;
                    isFirst = false;
                    lastEqual = -1;
                }else p2++;
            }
            if(p1 == l1) return true;
        }
        return false;
    }
    public List<String> stringMatching(String[] words) {
        List<String>list = new ArrayList();
        int len = words.length;
        for(int i=0;i<len;i++){
            String cur = words[i];
            for(int j=0;j<len;j++){
                String jStr = words[j];
                if(i== j) continue;
                if(contains(cur,jStr)){
                    list.add(cur);
                    break;
                }
            }
        }
        return list;
    }
}