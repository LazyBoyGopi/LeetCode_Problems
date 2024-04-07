class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0 , leftMax = 0;
        for(char ch : s.toCharArray())
        {
            if(ch == '(') {
                leftMin++;
                leftMax++;
            }
            else if(ch == '*')
            {
                leftMin--;
                leftMax++;
            }
            else if(ch == ')'){
                leftMin--;
                leftMax--;
            }
            if(leftMin < 0) leftMin =0;
            if(leftMax < 0) return false;
        }
        return leftMin == 0;
        // if(s.length() == 1 && s.charAt(0) != '*') return false;
        // char ar[] = s.toCharArray();
        // int open = 0 , stars = 0 , numberOfStarsUsed = 0;
        // for(char ch : ar)
        // {
        //     if(ch == '(') open++;
        //     else if(ch == '*') stars++;
        //     else if(ch == ')') {
        //         if(open == 0 && stars == 0) return false;
        //         else if(open > 0) open--;
        //         else {
        //             stars--;
        //             numberOfStarsUsed++;
        //         }
        //     }
        // }
        // System.out.println(open +" "+stars+" "+numberOfStarsUsed);
        // if(open > 0) {
        //     if(numberOfStarsUsed >= open) return true;
        //     return false;
        // }
        // return true;
    }
}