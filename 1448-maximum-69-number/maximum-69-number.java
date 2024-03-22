class Solution {
    public int maximum69Number (int num) {
        String s1 = Integer.toString(num);
        StringBuilder s = new StringBuilder(s1);
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '6')
            {
                s.setCharAt(i,'9');
                s1 = s.toString();
                return Integer.parseInt(s1);
            }
        }
        // for(int i=s.length()-1;i>=0;i--)
        // {
        //     if(s.charAt(i) == '9')
        //     {
        //         s.setCharAt(i,'6');
        //         s1 = s.toString();
        //         return Integer.parseInt(s1);
        //     }
        // }
        return num;
    }
}