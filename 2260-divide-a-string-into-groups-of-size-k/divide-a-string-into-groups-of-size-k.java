class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length(), idx = 0, arIdx = 0;
        int d =(int) Math.ceil((double)len/k);
        String[] ar = new String[d];
        while (idx + k <= len) {
            ar[arIdx++] = s.substring(idx, idx + k);
            idx += k;
        }
        if (idx < len) {
            ar[arIdx] = s.substring(idx);
            while (ar[arIdx].length() < k) {
                ar[arIdx] = ar[arIdx].concat(fill+"");
            }
        }
        return ar;
    }
}