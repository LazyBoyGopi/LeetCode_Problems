class Solution {
    public int generateKey(int num1, int num2, int num3) {
        StringBuilder ans = new StringBuilder();
        while(num1 > 0 && num2 > 0 && num3 >0){
            int curCh = 0;
            if(num1%10 > num2%10){
                curCh = num2%10;
            }else{
                curCh = num1%10;
            }
            if(curCh > num3%10)
            {
                curCh = num3%10;
            }
            ans.append(curCh);
            num1/=10;
            num2/=10;
            num3/=10;
        }
        return Integer.parseInt(ans.reverse().toString());
    }
}