class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            sb.append(ch-'a'+1);
        }
        String res = sb.toString();
        while(k > 0){
            int num = 0;
            for(char ch : res.toCharArray()){
                num += (ch-'0');
            }
            res = Integer.toString(num);
            k--;
        }
        return Integer.parseInt(res);
    }
}