class Solution {
    public String customSortString(String order, String s) {
        char[] ar = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int st = 0;
        for (int i = 0; i < order.length();) {
            int idx = s.indexOf(order.charAt(i), st);
            if (idx != -1) {
                sb.append(s.charAt(idx));
                ar[idx] = ' ';
                st = idx + 1;
            } else {
                st = 0;
                i++;
            }
        }
        for (char ele : ar) {
            if (ele != ' ') {
                sb.append(ele);
            }
        }
        return sb.toString();
    }
}