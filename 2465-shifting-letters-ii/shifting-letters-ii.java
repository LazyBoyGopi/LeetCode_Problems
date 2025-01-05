
//Brute Force
/*

class Solution {
    private void shiftForward(char[]ar,int st,int end){
        for(;st<=end;st++){
            if(ar[st] == 'z')
                ar[st] = 'a';
            else
                ar[st] = (char)(ar[st]+1);
        }
    }
    private void shiftBackward(char[]ar,int st,int end){
        for(;st<=end;st++){
            if(ar[st] == 'a')
                ar[st] = 'z';
            else
                ar[st] = (char)(ar[st]-1);
        }
    }
    private void shiftCharacters(char[]ar,int st,int end,int direc){
        if(direc == 1){
            shiftForward(ar,st,end);
        }else{
            shiftBackward(ar,st,end);
        }
    }
    public String shiftingLetters(String s, int[][] shifts) {
        char[]ar = s.toCharArray();
        for(int[]shift : shifts){
            shiftCharacters(ar,shift[0],shift[1],shift[2]);
        }
        return new StringBuilder().append(ar).toString();
    }
}

 */

//Accepted (but not optimised)
/*

class Solution {
    private void doShifting(int[]ar,int[]shift){
        int dif = shift[2] == 0 ? -1 : 1;
        int st = shift[0], end = shift[1];
        for(int i=st;i<=end;i++){
            ar[i] += dif;
        }
    }
    private char shiftCharacter(char curCh,int times){
        boolean isPositive = times >= 0 ? true : false;
        times = Math.abs(times);
        times %= 26;
        while(times > 0){
                if(isPositive){
                    if(curCh == 'z')
                        curCh = 'a';
                    else 
                        curCh = (char)(curCh + 1);
                }
                else{
                    if(curCh == 'a')
                        curCh = 'z'; 
                    else 
                        curCh = (char)(curCh - 1);
                }
                times--;
            }    
        return curCh;
    }
    public String shiftingLetters(String s, int[][] shifts) {
        int len = s.length();
        int[]ar = new int[len];
        for(int[] shift : shifts){
            doShifting(ar,shift);
        }
        char[]sAr = s.toCharArray();
        for(int i=0;i<len;i++){
            sAr[i] = shiftCharacter(sAr[i],ar[i]);
        }
        return new StringBuilder().append(sAr).toString();
    }
}

 */

 class Solution{
    private char shiftCharacter(char curCh,int times){
        boolean isPositive = times >= 0 ? true : false;
        times = Math.abs(times);
        times %= 26;
        while(times > 0){
                if(isPositive){
                    if(curCh == 'z')
                        curCh = 'a';
                    else 
                        curCh = (char)(curCh + 1);
                }
                else{
                    if(curCh == 'a')
                        curCh = 'z'; 
                    else 
                        curCh = (char)(curCh - 1);
                }
                times--;
            }    
        return curCh;
    }
    public String shiftingLetters(String s,int[][]shifts){
        int len = s.length();
        int[]ar = new int[len];
        StringBuilder sb = new StringBuilder();
        for(int[] shift : shifts){
            if(shift[2] == 1){
                ar[shift[0]]++;
                if(shift[1] < len-1) ar[shift[1]+1]--;
            }else{
                ar[shift[0]]--;
                if(shift[1] < len-1) ar[shift[1]+1]++;
            }
        }
        int count = 0;
        for(int i=0;i<len;i++){
            count += ar[i];
            sb.append(shiftCharacter(s.charAt(i),count));
        }
        return sb.toString();
    }
 }