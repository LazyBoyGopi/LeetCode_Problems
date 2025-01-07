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
        int lspTillNow = 0, i=1;
        while(i < len){
            char curCh = pattern.charAt(i), chAtL = pattern.charAt(lspTillNow);
            if(chAtL == curCh){
                lspTillNow++;
                lsp[i] = lspTillNow;
                i++;
            }else{
                if(lspTillNow > 0){
                    lspTillNow = lsp[lspTillNow-1];
                }
                else{
                    lsp[i] = 0;
                    i++;
                }
            }
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
    private boolean isSubString(String[]words,String cur,int includeIdx){
        for(int i=0;i<words.length;i++){
            if(i == includeIdx) continue;
            String word = words[i];
            if(word.contains(cur)) return true;
        }
        return false;
    }
    public List<String> stringMatching(String[] words) {
        List<String>list = new ArrayList();
        int len = words.length;
        for(int i=0;i<len;i++){
            String word = words[i];
            if(isSubString(words,word,i)){
                list.add(word);
            }
        }
        return list;
    }
}