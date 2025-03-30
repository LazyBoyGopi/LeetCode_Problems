class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length(), minLen = Math.min(l1,l2);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<minLen;i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if(l1 > minLen){
            sb.append(word1.substring(minLen));
        }else if(l2 > minLen){
            sb.append(word2.substring(minLen));
        }
        return sb.toString();
    }
}