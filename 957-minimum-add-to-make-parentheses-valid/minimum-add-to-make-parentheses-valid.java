class Solution {
    public int minAddToMakeValid(String s) {
        int opening = 0, closing = 0;
        for(char ch : s.toCharArray()){
            if(ch == ')'){
                if(opening > 0)
                    opening--;
                else closing++;
            }else{
                opening++;
            }
        }
        return opening+closing;
    }
}