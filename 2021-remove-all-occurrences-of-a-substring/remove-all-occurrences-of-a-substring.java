class Solution {
    public String removeOccurrences(String s, String part) {
        int len = part.length();
         
        for(int i=0;i<=s.length()-len;i++)
        {

            if(s.length()==len) 
            {
                if(s.equals(part)) return "";
                else return s;
            } 
            if((s.substring(i,i+len)).equals(part))
            {
                s = s.substring(0,i)+s.substring(i+len,s.length());
                i=-1;
            }
        }
        return s;
    }
}