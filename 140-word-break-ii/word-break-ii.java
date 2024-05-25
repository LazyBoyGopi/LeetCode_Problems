class Solution {
    private void backTrack(String s,  List<String> wordDict,int idx,List<String>list,StringBuilder temp){
        if(idx >= s.length()){
            list.add(temp.toString());
            return;
        }
        for(int i=idx;i<s.length();i++){
           
                String str = s.substring(idx,i+1);
                if(wordDict.contains(str)){
                    int lenBeforeAppend = temp.length();
                    if(temp.length() != 0)
                        temp.append(" ");
                    temp.append(str);
                    backTrack(s,wordDict,i+1,list,temp);
                    temp.delete(lenBeforeAppend,temp.length());
                }
           
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new LinkedList<>();
        backTrack(s,wordDict,0,list,new StringBuilder());
        return list;
    }
}