class Solution {
    private String backSpace(String s)
    {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray())
        {
            if(ch != '*') sb.append(ch);
            else sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
    public String removeStars(String s) {
        return backSpace(s);
    }
}