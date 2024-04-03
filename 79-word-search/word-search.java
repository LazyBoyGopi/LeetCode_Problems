class Solution {
    private boolean check(char[][]board,String word,int r,int c ,int curIdx,boolean isFirst)
    {
        if(curIdx == word.length()) return true;
        for(int i=r;i<board.length;i++)
        {
            for(int j=c;j<board[i].length;j++)
            {
                if(board[i][j] == ' ') return false;
                if(board[i][j] == word.charAt(curIdx))
                {
                    if(word.length() == curIdx+1) return true;
                    char ch = board[i][j];
                    board[i][j] = ' ';
                    if(i > 0)
                    {
                        if(check(board,word,i-1,j,curIdx+1,false)) return true;
                    }
                    if(i < board.length-1)
                    {
                        if(check(board,word,i+1,j,curIdx+1,false)) return true;
                    }
                    if(j < board[i].length-1)
                    {
                        if(check(board,word,i,j+1,curIdx+1,false)) return true;
                    }
                    if(j > 0)
                    {
                        if(check(board,word,i,j-1,curIdx+1,false)) return true;
                    }
                    board[i][j] = ch;
                }
                if(!isFirst) return false;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        return check(board,word,0,0,0,true);
    }
}