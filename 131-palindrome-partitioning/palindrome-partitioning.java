class Solution {
    private List<List<String>>ans;
    private int len;
    private String S;
    private boolean isPalindrome(String str){
        int l = 0, r = str.length()-1;
        while(l <= r){
            if(str.charAt(l++) != str.charAt(r--))
                return false;
        }
        return true;
    }
    private void getAllPartitioningPalindromes(int curIdx, List<String>curList){
        if(curIdx == len){
            ans.add(new ArrayList(curList));
            return;
        }
        for(int i=curIdx;i<len;i++){
            String curStr = S.substring(curIdx,i+1);
            if(isPalindrome(curStr)){
                curList.add(curStr);
                getAllPartitioningPalindromes(i+1,curList);
                curList.remove(curList.size()-1);
            }
            
        }

    }
    public List<List<String>> partition(String s) {
        ans = new ArrayList();
        len = s.length();
        S = s;
        getAllPartitioningPalindromes(0,new ArrayList());
        return ans;
    }
}