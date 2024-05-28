class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count =0;
        String []ar = text.split(" ");
        for(String str : ar){
            for(char ch : brokenLetters.toCharArray()){
                if(str.contains(ch+"")){
                    count++;
                    break;
                }
            }
        }
        return ar.length-count;
    }
}