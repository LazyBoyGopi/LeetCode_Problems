class Solution {
    public int minSwaps(String s) {
        int opening = 0, closing = 0, len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch == ']'){
                if(opening > 0)
                    opening--;
                else closing++;
            }else{
                opening++;
            }
        }
        return (opening+1)/2;
    }
}