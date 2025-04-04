public class Solution {
    public string LongestDiverseString(int a, int b, int c) {
        StringBuilder ans = new StringBuilder();
        if (a == 0 && b == 0 && c == 0)
            return ans.ToString();

        char curCh;
        if (a >= b && a >= c) {
            curCh = 'a';
            a--;
            ans.Append('a');
        } else if (b >= c && b >= a) {
            curCh = 'b';
            b--;
            ans.Append('b');
        } else {
            curCh = 'c';
            c--;
            ans.Append('c');
        }

        int count = 1;

        while (a > 0 || b > 0 || c > 0) {
            if (count < 2) {
                if ((a > 0 ) && (a >= b) && (a >= c)) {
                    ans.Append('a');
                    a--;
                    if(curCh == 'a') count++;
                    else {
                        curCh = 'a';
                        count = 1;
                    }
                } else if ((b > 0 ) &&(b >= a) && (b >= c)) {
                    ans.Append('b');
                    b--;
                    if(curCh == 'b') count++;
                    else {
                        curCh = 'b';
                        count = 1;
                    }
                } else if ((c > 0 ) &&(c >= a) && (c >= b)) {
                    ans.Append('c');
                    c--;
                    if(curCh == 'c') count++;
                    else {
                        curCh = 'c';
                        count = 1;
                    }
                }else break;
            } else {
                if (curCh == 'a') {
                    if(b > 0 && b >= c){
                        ans.Append('b');
                        b--;
                        curCh = 'b';
                    }else if(c > 0){
                        ans.Append('c');
                        c--;
                        curCh = 'c';
                    }else break;
                }
                else if(curCh == 'b'){
                    if(a > 0 && a >= c){
                        ans.Append('a');
                        a--;
                        curCh = 'a';
                    }else if(c > 0){
                        ans.Append('c');
                        c--;
                        curCh = 'c';
                    }else break;
                }else{
                    if(a > 0 && a >= b){
                        ans.Append('a');
                        a--;
                        curCh = 'a';
                    }else if(b > 0){
                        ans.Append('b');
                        b--;
                        curCh = 'b';
                    }else break;
                }
                count = 1;
            }
        }
        return ans.ToString();
    }
}