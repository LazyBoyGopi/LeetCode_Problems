class Solution {
    int max = 0;
    private  void addAllPaths(int[][]ar,int row,int col,int sum){
		if((row < 0 || col < 0 || row >= ar.length || col >= ar[0].length) || ar[row][col] == 0) {
			max = Math.max(sum,max);
			return;
		}
		int ele = ar[row][col];
		ar[row][col] = 0;
		addAllPaths(ar,row-1,col,sum+ele);
		addAllPaths(ar,row+1,col,sum+ele);
		addAllPaths(ar,row,col+1,sum+ele);
		addAllPaths(ar,row,col-1,sum+ele);
		ar[row][col] = ele;
	}
	private  int getPathWithMaxGold(int[][]ar){
		for(int i=0;i<ar.length;i++){
			for(int j=0;j<ar[i].length;j++){
				if(ar[i][j] != 0){
					 addAllPaths(ar,i,j,0);
				}
			}
		}
        return max;
	}
    public int getMaximumGold(int[][] grid) {
        return getPathWithMaxGold(grid);
    }
}