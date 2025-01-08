class Solution {
    private boolean isPrefixAndSuffix(String s1,String s2){
        int l1 = s1.length(), l2 = s2.length();
        if(l1 > l2) return false;
        for(int i=0;i<l1;i++){
            if(s1.charAt(i) != s2.charAt(i)) return false;
        }
        l2--;
        for(int i=l1-1;i>=0;i--,l2--){
            if(s1.charAt(i) != s2.charAt(l2)) return false;
        }
        return true;
    }
    public int countPrefixSuffixPairs(String[] words) {
        int len = words.length, totalCount = 0;
        for(int i=0;i<len;i++){
            String cur = words[i];
            for(int j=i+1;j<len;j++){
                if(i == j) continue;
                if(isPrefixAndSuffix(cur,words[j]))
                    totalCount++;
            }
        }
        return totalCount;
    }
}