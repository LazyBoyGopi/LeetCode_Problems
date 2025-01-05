//Brute Force

/*
class Solution {
    private char shiftCurCharacter(char curCh,int times){
        while(times > 0){
            if(curCh == 'z') curCh = 'a';
            else curCh = (char)(curCh+1);
            times--;
        }
        return curCh;
    }
    private void shiftTillNow(char[]ar,int end,int times){
        for(int i=0;i<=end;i++){
            ar[i] = shiftCurCharacter(ar[i],times);
        }
    }
    public String shiftingLetters(String s, int[] shifts) {
        int sLen = shifts.length;
        char[]ar = s.toCharArray();
        for(int i=0;i<sLen;i++){
            shiftTillNow(ar,i,shifts[i]);
        }
        return new StringBuilder().append(ar).toString();
    }
}
 */


//Optimised

class Solution {
    private char shiftCurCharacter(char curCh,long times){
        times %= 26;
        while(times > 0){
            if(curCh == 'z')
                curCh = 'a';
            else
                curCh = (char)(curCh+1);
            times--;
        }
        return curCh;
    }
    public String shiftingLetters(String s, int[] shifts) {
        long shiftsTillNow = 0;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=len-1;i>=0;i--){
            shiftsTillNow += shifts[i];
            sb.append(shiftCurCharacter(s.charAt(i),shiftsTillNow));
        }
        return sb.reverse().toString();
    }
}