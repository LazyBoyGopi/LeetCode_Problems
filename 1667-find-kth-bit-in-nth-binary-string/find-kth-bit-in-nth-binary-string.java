class Solution {
    StringBuilder[]ar = new StringBuilder[21];
    int lastIdx = 1;
    {
        ar[1] = new StringBuilder("0");
        ar[2] = new StringBuilder("011");
    }
    private StringBuilder invert(StringBuilder sb){
        StringBuilder inverted = new StringBuilder();
        for(int i=0;i<sb.length();i++){
            inverted.append(sb.charAt(i) == '0' ? '1' : '0');
        }
        return inverted;
    }
    private StringBuilder reverse(StringBuilder sb){
        return sb.reverse();
    }
    public char findKthBit(int n, int k) {
        StringBuilder cur = ar[lastIdx];
        n -= lastIdx;
        while(n >= 1 && cur.length() <= k){
            StringBuilder inverted = invert(cur);
            cur.append('1').append(reverse(inverted));
            ar[n] = cur;
            lastIdx = n;
            n--;
        }
        return cur.charAt(k-1);
    }
}