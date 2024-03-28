class Solution {
    public int maxNumberOfBalloons(String text) {
       int a = 0 , b = 0 , l = 0 , o = 0, n = 0;
       for(char ch : text.toCharArray())
       {
        switch(ch)
        {
            case 'a' : a++;
            break;
            case 'b' : b++;
            break;
            case 'l' : l++;
            break;
            case 'o' : o++;
            break;
            case 'n' : n++;
        }
       }
       l/=2;
       o/=2;
       return Math.min(a,Math.min(b,Math.min(l,Math.min(o,n))));
    }
}