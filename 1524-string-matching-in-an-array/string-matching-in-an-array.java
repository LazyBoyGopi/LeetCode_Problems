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
        int curLen = 0, i = 1;
        while(i<len){
            if(pattern.charAt(i) == pattern.charAt(curLen)){
                curLen++;
                lsp[i] = curLen;
                i++;
            }else{
                if(curLen > 0)
                    curLen = lsp[curLen-1];
                else
                    {
                        lsp[i] = 0;
                        i++;
                    }
            }
        }
        return lsp;
    }
    private boolean isMatching(String txt,String pattern,int[]lsp){
        int tLen = txt.length(), pLen = pattern.length(), i=0, j=0;
        if(pLen > tLen) return false;
        while(i < tLen){
            if(txt.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else{
                if(j > 0){
                    j = lsp[j-1];
                }else{
                    i++;
                }
            }
            if(j == pLen) return true;
        }
        return false;
    }
    public List<String> stringMatching(String[] words) {
        int len = words.length;
        List<String>list = new ArrayList();
        int[][]lsps = new int[len][];
        for(int i=0;i<len;i++){
            lsps[i] = getLSP(words[i]);
        }

        for(int i=0;i<len;i++){
            String pattern = words[i];
            for(int j=0;j<len;j++){
                if(i== j) continue;
                String txt = words[j];
                if(isMatching(txt,pattern,lsps[i])){
                    list.add(pattern);
                    break;
                }
            }
        }
        return list;
    }
}