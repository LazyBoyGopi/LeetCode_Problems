class Solution {
    public int minimumPushes(String word) {
        int len = word.length(), times = len/8, rem = len%8, ans = (times+1)*rem;
        while(times > 0)
            ans = ans+(times--*8);
        return ans;
    }
}