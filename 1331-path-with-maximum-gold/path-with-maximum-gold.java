class Solution {
    private static void addAllPaths(int[][]ar,int row,int col,List<Integer>list,int sum){
		if(ar[row][col] == 0 || (row < 0 || col < 0 || row >= ar.length || col >= ar[0].length)) {
			list.add(sum);
			return;
		}
		int ele = ar[row][col];
		ar[row][col] = 0;
		if(row > 0 ){
			addAllPaths(ar,row-1,col,list,sum+ele);
		}
		if(row < ar.length-1){
			addAllPaths(ar,row+1,col,list,sum+ele);
		}
		if(col < ar[0].length-1){
			addAllPaths(ar,row,col+1,list,sum+ele);
		}
		if(col > 0){
			addAllPaths(ar,row,col-1,list,sum+ele);
		}
		ar[row][col] = ele;
	}
	private static int getPathWithMaxGold(int[][]ar,List<Integer>list){
		for(int i=0;i<ar.length;i++){
			for(int j=0;j<ar[i].length;j++){
				if(ar[i][j] != 0){
					addAllPaths(ar,i,j,list,0);
				}
			}
		}
		int max = 0;
		for(int ele : list) if(max < ele ) max = ele;
		return max;
	}
    public int getMaximumGold(int[][] grid) {
        return getPathWithMaxGold(grid,new LinkedList<>());
    }
}