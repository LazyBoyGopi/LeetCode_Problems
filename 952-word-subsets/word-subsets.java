class Solution {
    int[] maxCharacters;
    List<String>ans;

    private int[] getCharacterCount(String str){
        int[] ar = new int[26];
        int len = str.length();
        for(int i=0;i<len;i++){
            ar[str.charAt(i)-'a']++;
        }
        return ar;
    }

    private boolean isSubSet(String a){
        int[]ch_a = getCharacterCount(a);
        for(int i=0;i<26;i++){
            if(ch_a[i] < maxCharacters[i]) {
                return false;
            }
        }
        return true;
    }

    private void addHighestCharactersCount(String[]words2){
        int l2 = words2.length;
        for(int i=0;i<l2;i++){
            int[]curCount = getCharacterCount(words2[i]);
            for(int idx=0;idx<26;idx++){
                maxCharacters[idx] = Math.max(maxCharacters[idx],curCount[idx]);
            }
        }
    }

    private void checkAllUniversalString(String[]words1){
        int l1 = words1.length;
        for(int i=0;i<l1;i++){
            boolean isUniversal = true;
            String cur = words1[i];
            if(!isSubSet(cur)){
                isUniversal = false;
            }
            if(isUniversal) ans.add(cur);
        }
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        maxCharacters = new int[26];
        addHighestCharactersCount(words2);
        ans = new ArrayList<>();
        checkAllUniversalString(words1);
        return ans;
    }
}