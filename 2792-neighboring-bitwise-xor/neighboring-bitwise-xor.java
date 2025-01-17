class Solution {
    private boolean checkWith(int[]derived,int firstBit){
        int len = derived.length,curBit = derived[0] ^ firstBit;
        for(int i=1;i<len-1;i++){
            curBit ^= derived[i];
        }
        return (curBit ^ derived[len-1]) == firstBit;
    }
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for(int ele : derived) xor ^= ele;
        return xor == 0;
        // if(derived.length == 1) return derived[0] == 0;
        // return checkWith(derived,0) || checkWith(derived,1);
    }
}