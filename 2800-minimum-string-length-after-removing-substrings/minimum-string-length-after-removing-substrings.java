class Solution {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (sb.length() == 0)
                sb.append(ch);
            else {
                char last = sb.charAt(sb.length() - 1);
                if ((last == 'A' && ch == 'B') || (last == 'C' && ch == 'D'))
                    sb.setLength(sb.length() - 1);
                else
                    sb.append(ch);
            }
        }
        return sb.length();
    }
}