class Solution {
    private boolean isPalindrome(String str){
        int low = 0 , high = str.length()-1;
        while(low <= high){
            if(str.charAt(low++) != str.charAt(high--)) return false;
        }
        return true;
    }
    public int countSubstrings(String s) {
        int count = 0 , len = s.length();
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(isPalindrome(s.substring(i,j+1))) count++;
            }
        }
        return count;
    }
}