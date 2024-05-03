class Solution {
    private String removeLeadingZeroes(String str)
    {
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i) != '0') return str.substring(i);
        }
        return "";
    }
    private boolean checkOneVersion(String[]ar,int idx)
    {
        for(int i=idx;i<ar.length;i++)
        {
            String s = ar[idx].startsWith("0") ? removeLeadingZeroes(ar[i]) : ar[i];
            int num = s.length() != 0 ? Integer.parseInt(s) : 0;
            if(num > 0) return true;
        }
        return false;
    }
    public int compareVersion(String version1, String version2) {
        String ar1 [] = version1.split("\\.");
        String ar2 [] = version2.split("\\.");
        int l1 = 0 , l2 = 0;
        while(l1 < ar1.length && l2 < ar2.length)
        {
            String s1 = ar1[l1].startsWith("0") ? removeLeadingZeroes(ar1[l1]) : ar1[l1];
            String s2 = ar2[l2].startsWith("0") ? removeLeadingZeroes(ar2[l2]) : ar2[l2];
            int num1 = s1.length() != 0 ? Integer.parseInt(s1) : 0;
            int num2 = s2.length() != 0 ? Integer.parseInt(s2) : 0;
            if(num1 > num2) return 1;
            if(num1 < num2) return -1;
            l1++;
            l2++;
        }
        if(l1 < ar1.length) {
            if(checkOneVersion(ar1,l1)) return 1;
        }
        if(l2 < ar2.length)
             if(checkOneVersion(ar2,l2)) return -1 ;
        return 0;
    }
}