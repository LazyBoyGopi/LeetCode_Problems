public class Solution {
    public int MinSwaps(string s) {
        int brackets = 0;
        foreach(char ch in s.ToCharArray()){
            if(ch == ']' && brackets > 0){
                brackets--;
            }else brackets++;
        }
        return (brackets+1)/2;
    }
}