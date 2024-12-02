class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int curIdx = 0, len = sentence.length(), searchWordLen = searchWord.length(), wordsCount = 0;
        while(curIdx < len){
            wordsCount++;
            int searchWordIdx = 0;
            while(curIdx < len && searchWordIdx < searchWordLen && searchWord.charAt(searchWordIdx) == sentence.charAt(curIdx)){
                curIdx++;
                searchWordIdx++;
            }
            if(searchWordIdx >= searchWordLen) return wordsCount;
            while(curIdx < len && sentence.charAt(curIdx) != ' '){
                curIdx++;
            }
            curIdx++;
        }
        return -1;
    }
}