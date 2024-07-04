class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while(a != 0 || b != 0 || c != 0){
            int a1 = a%2;
            int b1 = b%2;
            int c1 = c%2;
            System.out.println(a1+" "+b1+" "+c1);
            if((a1 | b1) != c1){
                if(c1 == 0){
                    if(a1 == 1){
                        count++;
                    }
                    if(b1 == 1){
                        count++;
                    }
                }else{
                    count++;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
            System.out.println(a+" "+b+" "+c);
        }
        return count;
    }
}