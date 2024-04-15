class Solution {
    private void rotate(int[]ar,int times)
    {
        
        while(times > 0)
        {
            int[]cells = new int[8];
            cells[0] = 0;
            for(int i=1;i<cells.length-1;i++)
            {
                if((ar[i-1] == 0 && ar[i+1] == 0) || (ar[i-1] == 1 && ar[i+1] == 1))
                {
                    cells[i] = 1;
                }
                else cells[i] = 0;
            }
            cells[cells.length-1] = 0;
            for(int i = 0 ;i<8;i++)
            {
                ar[i] = cells[i];
            }
            times--;
        }
    }
    public int[] prisonAfterNDays(int[] cells, int n) {
        int times = n%14;
        if(times == 0) times = 14;
        rotate(cells,times);
        return cells;
    }
}