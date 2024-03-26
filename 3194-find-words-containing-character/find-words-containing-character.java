class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new LinkedList<Integer>();
        for(int i=0;i<words.length;i++)
        {
            inner : for(char ch : words[i].toCharArray())
            {
                if(ch == x){
                     list.add(i);
                     break inner;
                }
            }
        }
        return list;
    }
}