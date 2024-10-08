public class Solution {
    public int MinAddToMakeValid(string s) {
        int opening = 0, closing = 0;
        foreach(char ch in s.ToCharArray()){
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