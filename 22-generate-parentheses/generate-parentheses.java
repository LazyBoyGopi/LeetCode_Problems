class Solution {
    List<String>ans;
    private void getAns(int opened,int closed,int n,StringBuilder str){
        if(closed == n){
            ans.add(str.toString());
            return;
        }
        if(opened > closed){
            str.append(')');
            getAns(opened,closed+1,n,str);
            str.deleteCharAt(str.length()-1);
        }
        if(opened < n){
            str.append('(');
            getAns(opened+1,closed,n,str);
            str.deleteCharAt(str.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        ans = new LinkedList<String>();
        getAns(0,0,n,new StringBuilder());
        return ans;
    }
}