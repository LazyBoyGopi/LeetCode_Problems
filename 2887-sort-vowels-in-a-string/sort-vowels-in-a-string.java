class Solution {
    public String sortVowels(String s) {
        int[] ar = new int[128];
        String vowels = "AEIOUaeiou";
        for(char ch : s.toCharArray())
        {
            if(vowels.indexOf(ch) != -1)
            {
                ar[ch]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray())
        {
            if(vowels.indexOf(ch) == -1)
            {
                sb.append(ch);
            }
            else{
                for(int i=0;i<128;i++)
                {
                    int ele = ar[i];
                    if(ele > 0)
                    {
                        sb.append((char)i);
                        ar[i]--;
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}