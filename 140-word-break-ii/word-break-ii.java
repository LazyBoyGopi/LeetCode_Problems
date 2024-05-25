class Solution {
    private void backTrack(String s,Set<String>wordDict,int idx,List<String>list,StringBuilder sb){
        if(idx >= s.length()){
            list.add(sb.toString());
            return;
        }
        for(int i=idx;i<s.length();i++){
            String temp = s.substring(idx,i+1);
            if(wordDict.contains(temp)){
                int len = sb.length();
                if(len != 0) sb.append(" ");
                sb.append(temp);
                backTrack(s,wordDict,i+1,list,sb);
                sb.delete(len,sb.length());
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String>list = new LinkedList<>();
        Set<String>set = new HashSet<>(wordDict);
        backTrack(s,set,0,list,new StringBuilder());
        return list;
    }
}