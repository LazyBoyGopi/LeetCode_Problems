class Solution {
    StringBuilder[]ar = new StringBuilder[21];
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
        StringBuilder cur = new StringBuilder("0");
        if(ar[n] != null) cur = ar[n];
        while(n > 1){
            StringBuilder inverted = invert(cur);
            cur.append('1').append(reverse(inverted));
            ar[n] = cur;
            n--;
            if(cur.length() > k) break;
        }
        return cur.charAt(k-1);
    }
}