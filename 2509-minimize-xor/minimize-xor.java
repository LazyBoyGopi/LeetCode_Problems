class Solution {
    private int getSetBits(int num){
        int setBits = 0;
        while(num > 0){
            setBits += (num&1);
            num >>= 1;
        }
        return setBits;
    }
    private boolean[] getBinaryRepresentation(int num){
        boolean[]binary = new boolean[32];
        int idx = 31;
        while(num > 0){
            binary[idx--] = ((num&1) == 1);
            num >>= 1;
        }
        return binary;
    }
    public int minimizeXor(int num1, int num2) {
        int setBits = getSetBits(num2);
        boolean[]bits = getBinaryRepresentation(num1);
        int ans = 0;
        long pow = (long)Math.pow(2,31);
        int i=0;
        for(;i<32 && setBits > 0;i++){
            if(bits[i]){
                ans += pow;
                setBits--;
            }
            pow >>= 1;
        }
        i=31;
        pow = 1;
        while(setBits > 0){
            if(!bits[i]){
                ans += pow;
                setBits--;
            }
            i--;
            pow <<= 1;
        }
        return ans;
    }
}