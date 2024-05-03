class Solution {
    private String removeLeadingZeroes(String str)
    {
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i) != '0') return str.substring(i);
        }
        return "";
    }
    public int compareVersion(String version1, String version2) {
        String ar1 [] = version1.split("\\.");
        String ar2 [] = version2.split("\\.");
        int l1 = 0 , l2 = 0;
        while(l1 < ar1.length || l2 < ar2.length)
        {
            int num1 = l1 < ar1.length ? Integer.parseInt(ar1[l1]) : 0;
            int num2 = l2 < ar2.length ? Integer.parseInt(ar2[l2]) : 0;
            if(num1 > num2) return 1;
            if(num1 < num2) return -1;
            l1++;
            l2++;
        }
        return 0;
    }
}