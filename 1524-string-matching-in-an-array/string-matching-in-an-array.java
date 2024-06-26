class Solution {
    public List<String> stringMatching(String[] words) {
        List<String>list = new LinkedList<>();
        int len = words.length;
        for(int i=0;i<len;i++){
            if(isSubString(words,i)) list.add(words[i]);
        }
        return list;
    }
    private boolean isSubString(String[]words,int j){
        for(int i=0;i<words.length;i++){
            if(j != i && words[i].contains(words[j])) return true;
        }
        return false;
    }
}