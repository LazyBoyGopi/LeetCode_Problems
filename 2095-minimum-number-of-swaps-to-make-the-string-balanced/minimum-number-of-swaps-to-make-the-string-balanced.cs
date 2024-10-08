public class Solution {
    public int MinSwaps(string s) {
        int brackets = 0;
        for(int i=0;i<s.Length;i++){
            if(s[i] == ']' && brackets > 0){
                brackets--;
            }else brackets++;
        }
        return (brackets+1)/2;
    }
}