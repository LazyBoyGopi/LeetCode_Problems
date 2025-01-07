class Solution {
    /*private boolean contains(String first,String second){
        int p1 = 0, p2 = 0,l1 = first.length(), l2 = second.length();
        if(l1 > l2) return false;
        boolean isFirst = false;
        int lastEqual = -1;
        while(p1 < l1 && p2 < l2){
            if(first.charAt(p1) == second.charAt(p2)){
                p1++;
               
                p2++;
            }else{
                p1 = 0;
                //  p2++;
            }
            if(p1 == l1) return true;
        }
        return false;
    } */
    private int[] getLSP(String pattern){
        int len = pattern.length();
        int[]lsp = new int[len];
        int lspTillNow = 0;
        for(int i=1;i<len;i++){
            char curCh = pattern.charAt(i);
            while(lspTillNow > 0 && pattern.charAt(lspTillNow) != curCh){
                lspTillNow--;
            }
            if(curCh == pattern.charAt(lspTillNow)) lspTillNow++;
            lsp[i] = lspTillNow;
        }
        return lsp;
    }
    private boolean contains(String pattern,String txt){
        int[]lsp = getLSP(pattern);
        int pLen = pattern.length(), tLen = txt.length();
        int i=0, j=0;
        while(i < tLen){
            if(pattern.charAt(j) == txt.charAt(i)){
                i++;
                j++;
            }else{
                if(j > 0)
                    j = lsp[j-1];
                else 
                    i++;
            }
            if(j == pLen){
                return true;
            }
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