class Solution {
    public int minAddToMakeValid(String s) {
        int opening = 0, closing = 0, len = s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i) ==')')
                if(opening > 0) opening--;
                else closing++;
            else opening++;
        }
        return opening+closing;
    }
}