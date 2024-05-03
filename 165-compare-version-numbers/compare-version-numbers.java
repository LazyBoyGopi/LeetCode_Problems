class Solution {
    private String removeLeadingZeores(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) != '0') {
                return s.substring(i,s.length());
            }
        }
        return "";
    }
    public int compareVersion(String version1, String version2) {
        int l1 = 0 , l2 = 0 , last1 =0 , last2=0;
        while(l1 < version1.length() && l2 < version2.length())
        {
            while(l1 < version1.length() && version1.charAt(l1) != '.') l1++;
            while(l2 < version2.length() && version2.charAt(l2) != '.') l2++;
            String s1 = removeLeadingZeores(version1.substring(last1,l1));
            String s2 = removeLeadingZeores(version2.substring(last2,l2));
            int n = (s1.length() != 0 ? Integer.parseInt(s1) : 0) - (s2.length() != 0 ? Integer.parseInt(s2) : 0);
            if(n < 0)
                return -1;
            if(n > 0) 
                return 1;
            else{
                last1 = l1+1;
                last2 = l2+1;
                l1++;
                l2++;
            }
        }
        while(l1 < version1.length())
        {
            while(l1 < version1.length() && version1.charAt(l1) != '.') l1++;
            String s = removeLeadingZeores(version1.substring(last1,l1));
            int n = s.length() != 0 ? Integer.parseInt(s) : 0;
            if(n == 0)
            {
                last1 = l1+1;
                l1++;
            }
            else if(n > 0) return 1;
        }
        while(l2 < version2.length())
        {
            while(l2 < version2.length() && version2.charAt(l2) != '.') l2++;
            String s = removeLeadingZeores(version2.substring(last2,l2));
            int n = s.length() != 0 ? Integer.parseInt(s) : 0;
            if(n == 0)
            {
                last2 = l2+1;
                l2++;
            }
            else if(n > 0) return -1;
        }
        return 0;
    }
}