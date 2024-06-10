class Solution {
    static int[] dp = new int[(int)1e4+1];
    private boolean check(int num){
        if(dp[num] == 2) return true;
        if(dp[num] == 1) return false;
        int originalNum = num;
        int reversedNum = 0 , place = 1;
        boolean isValid = true , isDifferent = false;
        while(num > 0){
            int last = num%10;
            num /=10;
            int reversedDigit = switch(last){
                case 0 -> 0;
                case 1 -> 1;
                case 2 -> 5;
                case 5 -> 2;
                case 6 -> 9;
                case 8 -> 8;
                case 9 -> 6;
                default -> -1;
            };

            if(reversedDigit == -1){
                isValid = false;
                break;
            }
            if(last != reversedDigit) isDifferent = true;

            reversedNum = reversedDigit * place + reversedNum;
            place *=10;
        }

        if(isValid && isDifferent) {
            dp[originalNum] = 2;
            return true;
        }
        else {
            dp[originalNum] = 1;
            return false;
        }
    }
    public int rotatedDigits(int n) {
        int count =0;
        for(int i=1;i<=n;i++){
            if(check(i)) count++;
        }
        return count;
    }
}