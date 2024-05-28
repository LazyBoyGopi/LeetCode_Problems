class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        for(int i=0;i<len;){
            if(len-2 == i){
                if(bits[i] == 0) return true;
                return false;
            }
            if(bits[i] == 1) i+=2;
            else i++;
        }
        return true;
    }
}