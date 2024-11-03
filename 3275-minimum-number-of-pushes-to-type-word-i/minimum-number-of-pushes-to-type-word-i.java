class Solution {
    public int minimumPushes(String word) {
        byte len = (byte)word.length(), times = (byte)(len/8), rem = (byte)(len%8), ans = (byte)((times+1)*rem);
        while(times > 0){
            ans = (byte)(ans+(times--*8));
        }
        return ans;
    }
}