class Solution {
    private void fun(String s, List<String>list,int idx,StringBuilder newString){
        if(idx == s.length()){
            list.add(new String(newString));
            return;
        }
        char ch = s.charAt(idx);
        fun(s,list,idx+1,newString.append(ch));
        newString.setLength(newString.length()-1);
        
        if(Character.isAlphabetic(ch)){
            if(ch >= 'a' && ch <='z'){
                ch = (char)(ch-32);
                newString.append(ch);
            }
            else {
                ch = (char)(ch+32);
                newString.append(ch);
            }
            fun(s,list,idx+1,newString);
            newString.setLength(newString.length()-1);
        }
    }
    public List<String> letterCasePermutation(String s) {
        List<String>list = new LinkedList<>();
        fun(s,list,0,new StringBuilder());
        return list;
    }
}