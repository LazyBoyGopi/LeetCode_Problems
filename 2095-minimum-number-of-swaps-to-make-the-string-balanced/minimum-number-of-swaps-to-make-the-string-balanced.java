class Solution {
    public int minSwaps(String s) {
        int brackets = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ']' && brackets > 0){
                brackets--;
            }else brackets++;
        }
        return (brackets+1)/2;
    }
}