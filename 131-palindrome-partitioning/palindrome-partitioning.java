class Solution {
    private boolean isPalindrome(String s,int st,int end){
        while(st <= end){
            if(s.charAt(st++) != s.charAt(end--)) return false;
        }
        return true;
    }
    private void getAns(String s, List<List<String>> list, List<String>temp,int idx){
        if(idx == s.length()){
            list.add(new LinkedList(temp));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                temp.add(s.substring(idx,i+1));
                getAns(s,list,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> list = new LinkedList<>();
        getAns(s,list,new LinkedList(),0);
        return list;
    }
}