class Solution {
    String[]keyboard ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    void possibleCombinations(String digits,StringBuilder ans,List<String>list)
    {
        if(digits.length() == 0){
            list.add(ans.toString());
            return;
        }
        String key = keyboard[digits.charAt(0)-48];
        for(int i=0;i<key.length();i++)
        {
            possibleCombinations(digits.substring(1),ans.append(key.charAt(i)),list);
            ans.setLength(ans.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String>list = new ArrayList<>();
        if(digits.length() == 0) return list;
        possibleCombinations(digits,new StringBuilder(),list);
        return list;
    }
}