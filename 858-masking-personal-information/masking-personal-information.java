class Solution {
    private String convertFromEmail(String str)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1;i>=0;i--)
        {
            char ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z') ch = (char)(ch + 32);
            sb.insert(0,ch);
            if(sb.length() >= 4)
            {
                if(sb.charAt(1) == '@')
                {
                    sb.insert(0,"*****");
                    i=1;
                }
            }
        }
        return sb.toString();
    }
    private String convertFromPhoneNumber(String str)
    {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=str.length()-1;i>=0;i--)
        {
            char ch = str.charAt(i);
            if(sb.length() == 4) {
                sb.insert(0,"***-***-");
            }
            if((ch >= '0' && ch <= '9')) {
                if(sb.length() < 4 )
                    sb.insert(0,ch);
                count++;
            }
        }
        System.out.println(count);
        if(count == 10) return sb.toString();
        if(count == 11) return sb.insert(0,"+*-").toString();
        if(count == 12) return sb.insert(0,"+**-").toString();
        return sb.insert(0,"+***-").toString();
    }
    public String maskPII(String s) {
       
       if(s.contains("@")) return convertFromEmail(s);
       return convertFromPhoneNumber(s);
    }
}