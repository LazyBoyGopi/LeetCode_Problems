class Solution {
    static int[]dp = new int[(int)1e4+1];
    private boolean checkWhetherIsItAGoodInteger(int num){
        if(dp[num] == 2) return true;
        if(dp[num] == 1) return false;

        int originalNum = num;
        int rev = 0 , place = 1;
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
            if(reversedDigit == -1) {
                isValid = false;
                break;
            }
            if(reversedDigit != last) isDifferent = true;
            rev =(reversedDigit*place)+rev;
            place *= 10;
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
        int count = 0;
        for(int i=1;i<=n;i++){
            if(checkWhetherIsItAGoodInteger(i)) count++;
        }
        return count;
    }
}

/*class Solution {
    static int[] dp = new int[(int)1e4 + 1];

    private boolean checkWhetherIsItAGoodInteger(int num) {
        if (dp[num] == 2) return true;
        if (dp[num] == 1) return false;

        int originalNum = num;
        int rotatedNum = 0;
        int place = 1;
        boolean isValid = true;
        boolean isDifferent = false;

        while (num > 0) {
            int last = num % 10;
            num /= 10;
            int rotatedDigit = switch (last) {
                case 0 -> 0;
                case 1 -> 1;
                case 2 -> 5;
                case 5 -> 2;
                case 6 -> 9;
                case 9 -> 6;
                case 8 -> 8;
                default -> -1;
            };
            if (rotatedDigit == -1) {
                isValid = false;
                break;
            }
            if (rotatedDigit != last) isDifferent = true;
            rotatedNum = rotatedDigit * place + rotatedNum;
            place *= 10;
        }

        if (isValid && isDifferent) {
            dp[originalNum] = 2; // Good integer
            return true;
        } else {
            dp[originalNum] = 1; // Not a good integer
            return false;
        }
    }

    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (checkWhetherIsItAGoodInteger(i)) count++;
        }
        return count;
    }
}*/
