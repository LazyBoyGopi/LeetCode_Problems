class Solution {
    private void reverse(char[]ar,int st,int end)
    {
        while(st<=end)
        {
            char temp = ar[st];
            ar[st] = ar[end];
            ar[end] = temp;
            st++;
            end--;
        }
    }
    public String reversePrefix(String word, char ch) {
        char ar [] = word.toCharArray();
        int i;
        for(i=0;i<ar.length;i++)
        {
            if(ch == ar[i]) break;
        }
        if(i == ar.length) return word;
        reverse(ar,0,i);
        return new StringBuilder().append(ar).toString();
    }
}