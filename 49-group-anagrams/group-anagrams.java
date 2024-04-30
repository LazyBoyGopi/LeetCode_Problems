class Solution {
    private boolean equals1(int[]ar1 , int[]ar2)
    {
        for(int i=0;i<26;i++)
        {
            if(ar1[i] != ar2[i]) return false;
        }
        return true;
    }
    private int[] getCount(String s)
    {
        int[]ar = new int[26];
        for(char ch : s.toCharArray())
        {
            ar[ch-'a']++;
        }
        return ar;
    }
    private List<List<String>> getGroupAnagrams(String[]strs)
    {
        List<List<String>> listOfAnagrams = new LinkedList<>();
        for(int i=0;i<strs.length;i++)
        {
            List<String> temp = new LinkedList<>();
            if(strs[i] == null) continue;
            temp.add(strs[i]);
            int[]ar = getCount(strs[i]);
            for(int j=i+1;j<strs.length;j++)
            {
                if(strs[j] != null)
                {
                    int[]ar1 = getCount(strs[j]);
                    if(equals1(ar,ar1))
                    {
                        temp.add(strs[j]);
                        strs[j] = null;
                    }
                }
            }
            listOfAnagrams.add(temp);
            strs[i] = null;
        }
        return listOfAnagrams;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        return getGroupAnagrams(strs);
    }
}