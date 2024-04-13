class Solution {
    private int compareBoth(String s1 , String s2)
    {
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i) > s2.charAt(i)) return 1;
        }
        return -1;
    }
    public String largestGoodInteger(String num) {
        char last = num.charAt(0);
        String mightBeAnswer = "0";
        int count = 1;
        for(int i=1;i<num.length();i++)
        {
            if(num.charAt(i) == last) count++;
            else{
                last = num.charAt(i);
                count = 1;
            }
            if(count == 3)  {
                String cur = num.substring(i-2,i+1);
                if(compareBoth(mightBeAnswer,cur) == -1){
                    mightBeAnswer = cur;
                }
                last = num.charAt(i);
                count = 1;
            }
        }
        if(!mightBeAnswer.equals("0"))
        return mightBeAnswer;
        return "";
    }
}