class Solution {
    private boolean isPalindrome(String s){
        if(s.length() == 0) return false;
        int st = 0 , end = s.length()-1;
        while(st <= end){
            if(s.charAt(st) != s.charAt(end)) return false;
            st++;
            end--;
        }
        return true;
    }
    private void getAns(String s, List<List<String>>list,List<String>temp,int idx){
        if(idx == s.length()){
            list.add(new ArrayList(temp));
            return;
        }
        for(int i=idx+1;i<=s.length();i++){
            if(isPalindrome(s.substring(idx,i))){
                temp.add(s.substring(idx,i));
                getAns(s,list,temp,i);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> list = new LinkedList();
        getAns(s,list,new LinkedList(),0);
        return list;
    }
}