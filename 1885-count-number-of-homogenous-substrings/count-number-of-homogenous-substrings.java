class Solution {
    public int countHomogenous(String s) {
        char lastEle = s.charAt(0);
        long count = 1 , total = 0 , MOD = 1000000007;
        for(int i=1;i<s.length();i++)
        {
            if(lastEle == s.charAt(i)) count++;
            else{
                total += ((count*(count+1))/2)%MOD;
                lastEle = s.charAt(i);
                count =1;
            }
        }
        total += ((count*(count+1))/2)%MOD;
        return (int)total;
    }
}