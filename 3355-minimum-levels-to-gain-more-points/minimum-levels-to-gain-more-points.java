class Solution {
    public int minimumLevels(int[] possible) {
        int sum = possible[0] == 0 ? -1 : 1;
        possible[0] = possible[0] == 0? -1 : 1;
        for(int i=1;i<possible.length;i++)
        {
            if(possible[i] == 0) sum -= 1;
            else sum += 1;
            possible[i] = sum;
        }
        for(int i=0;i<possible.length-1;i++)
        {
            if(possible[i] > possible[possible.length-1]-possible[i]) return i+1;
        }
        return -1;
    }
}