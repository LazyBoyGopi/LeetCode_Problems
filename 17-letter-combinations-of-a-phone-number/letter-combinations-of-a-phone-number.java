class Solution {
    List<String>ans;
    String[]keypad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private void checkAllCombinations(String digits,int idx,StringBuilder sb){
        if(idx >= digits.length()){
            if(sb.length() > 0)
                ans.add(sb.toString());
            return;
        }
        String curStr = keypad[digits.charAt(idx)-'0'];
        int len = curStr.length();
        for(int i=0;i<len;i++){
            sb.append(curStr.charAt(i));
            checkAllCombinations(digits,idx+1,sb);
            sb.setLength(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList();
        checkAllCombinations(digits,0,new StringBuilder());
        return ans;
    }
}