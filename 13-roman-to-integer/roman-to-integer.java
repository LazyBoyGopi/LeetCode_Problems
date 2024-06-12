class Solution {
    private int convert(char ch){
        return switch(ch){
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            default -> 1000;
        };
    }
    public int romanToInt(String s) {
        int ans = 0, last = convert(s.charAt(0)) , n = s.length();
        for(int i=1;i<n;i++){
            int cur = convert(s.charAt(i));
            if(last >= cur){
                ans += last;
            }
            else ans -= last;
            last = cur;
        }
        return ans+last;
    }
}