class Solution {
    private boolean check(String temp,String s)
    {
        StringBuilder sb = new StringBuilder();
        while(true)
        {
            sb.append(temp);
            if(sb.toString().equals(s)) return true;
            if(sb.length() > s.length()) break;
        }
        return false;
        // while(s.length() > 0)
        // {
        //     if(s.indexOf(temp,0) != -1)
        //     {
        //         s = s.replace(temp,"");
        //     }
        //     else break;
        // }
        // return s.length() == 0;
    }
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length() > str2.length())
        {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int end = str1.length();
        while(end > 0)
        {
            String temp = str1.substring(0,end);
            if(check(temp,str1) && check(temp,str2)) return temp;
            end--;
        }
        return "";
    }
}