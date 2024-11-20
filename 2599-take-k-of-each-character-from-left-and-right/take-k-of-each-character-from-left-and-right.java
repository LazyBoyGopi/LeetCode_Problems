class Solution {
    public int takeCharacters(String s, int k) {
        int ta = 0, tb = 0, tc = 0, len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch == 'a') ta++;
            else if(ch == 'b') tb++;
            else tc++;
        }
        if(ta < k || tb < k || tc < k) return -1;
        int left = 0, minLen = len, right = 0;
        while(right < len){
            char ch = s.charAt(right);
            if(ch == 'a') ta--;
            else if(ch == 'b') tb--;
            else tc--;
            while(left <= right && (ta < k || tb < k || tc < k)){
                ch = s.charAt(left++);
                if(ch == 'a') ta++;
                else if(ch == 'b') tb++;
                else tc++;
            }
            minLen = Math.min(minLen,len-(right-left+1));
            right++;
        }
        return minLen;
    }
}

/*
 * if(k == 0) return 0;
 * if(s.length() < 3) return -1;
 * s += s;
 * int len = s.length(), minMin = len+1;
 * int ac = 0, bc = 0, cc = 0,last = 0;
 * for(int i=0;i<len;i++){
 * char ch = s.charAt(i);
 * switch(ch){
 * case 'a' : ac++;
 * break;
 * case 'b' : bc++;
 * break;
 * default : cc++;
 * }
 * while(ac >= k && bc >= k && cc >= k){
 * System.out.println(last+" "+i+" "+minMin);
 * minMin = Math.min(minMin,i-last+1);
 * ch = s.charAt(last);
 * switch(ch){
 * case 'a' : ac--;
 * break;
 * case 'b' : bc--;
 * break;
 * default : cc--;
 * }
 * last++;
 * }
 * }
 * return minMin > len ? -1 : minMin;
 * 
 * 
 * int len = s.length;
 * int[][]pre = new int[len][3];
 * int[][]suf = new int[len][3];
 * int a = 0, b = 0, c = 0;
 * int minLen = len+1;
 * for(int i=0;i<len;i++){
 * char ch = s.charAt(i);
 * if(ch == 'a') a++;
 * else if(ch == 'b') b++;
 * else c++;
 * if((minLen != len+1) && (a >= k && b >= k && c >= k))
 * minLen = i;
 * pre[i][0] = a;
 * pre[i][1] = b;
 * pre[i][2] = c;
 * }
 * a=0;
 * b=0;
 * c=0;
 * int minLen2 = len+1;
 * for(int i=len-1;i>=0;i--){
 * char ch = s.charAt(i);
 * if(ch == 'a') a++;
 * else if(ch == 'b') b++;
 * else c++;
 * if((minLen != len+1) && (a >= k && b >= k && c >= k))
 * minLen = len-i+1;
 * sum[i][0] = a;
 * sum[i][1] = b;
 * sum[i][2] = c;
 * }
 * int left = 0, right = 0;
 * while(left >= right){
 * if(pre[])
 * }
 * 
 */