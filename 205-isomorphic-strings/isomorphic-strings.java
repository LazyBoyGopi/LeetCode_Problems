class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        // StringBuilder sb = new StringBuilder();
        for(int i=0;i<t.length();i++)
        {
            if(!map.containsKey(t.charAt(i)))
            {
                map.put(t.charAt(i),s.charAt(i));
            }
            else {
                if(map.get(t.charAt(i)) != s.charAt(i)) return false;
            }
        }
        Map<Character,Character> map1 = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(!map1.containsKey(s.charAt(i)))
            {
                map1.put(s.charAt(i),t.charAt(i));
            }
            else {
                if(map1.get(s.charAt(i)) != t.charAt(i)) return false;
            }
        }
        return true;
        // int[]freq1 = new int[26];
        // int[]freq2 = new int[26];
        // for(int i=0;i<s.length();i++)
        // {
        //     freq1[s.charAt(i)-97]++;
        // }
        // for(int i=0;i<t.length();i++)
        // {
        //     freq2[t.charAt(i)-97]++;
        // }
        // Arrays.sort(freq1);
        // Arrays.sort(freq2);
        // return Arrays.equals(freq1,freq2);
        // int p1 = 0 , p2 =0;
        // System.out.println(Arrays.toString(freq1) +"\n"+ Arrays.toString(freq2));
        // while(p1 < 26 && p2 < 26)
        // {
        //     if(freq1[p1] != 0 && freq2[p2] != 0)
        //     {
        //         if(freq1[p1] != freq2[p2]) return false;
        //         p1++;
        //         p2++;
        //     }
        //     if(freq1[p1] == 0) p1++;
        //     if(freq2[p2] == 0) p2++;
        // }
        // return true;
    }
}