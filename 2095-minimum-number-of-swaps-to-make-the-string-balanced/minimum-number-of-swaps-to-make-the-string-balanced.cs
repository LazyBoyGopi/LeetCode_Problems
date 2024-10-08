public class Solution {
    public int MinSwaps(string s) {
        int opening = 0, closing = 0;
        int swaps = 0;
        for(int i=0;i<s.Length;i++){
            char ch = s[i];
            if(ch == ']') closing++;
            else opening++;
            if(closing > opening) {
                swaps++;
                opening++;
                closing--;
            }
        }
        return swaps;
    }
}