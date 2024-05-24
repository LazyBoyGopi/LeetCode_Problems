class Solution {
    int max = 0;
    private Map<Character,Integer> getCount(char[]letters){
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : letters){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        return map;
    }
    private void backTrack(String[]words,int[]score,Map<Character,Integer>map,int idx,int curScore){
        if(idx == words.length) {
            max = Math.max(max,curScore);
            return;
        }
        int num = isPossible(words[idx],map,score);
        if(num != -1){
            curScore += num;
            backTrack(words,score,map,idx+1,curScore);
            curScore -= num;
            add(words[idx],map);
        }
        backTrack(words,score,map,idx+1,curScore);
    }
    private int isPossible(String str,Map<Character,Integer>map,int[]score){
        List<Character>list = new LinkedList<>();
        int curScore = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                curScore += score[ch-'a'];
                int count = map.get(ch);
                if(count > 1){
                    map.put(ch,map.get(ch)-1);
                }
                else map.remove(ch);
                list.add(ch);
            }
            else {
                add(list,map);
                return -1;
            }
        }
        return curScore;
    }
    private void add(List<Character>list,Map<Character,Integer>map){
        for(char ch : list){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
    }
    private void add(String str,Map<Character,Integer>map){
        for(char ch : str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        Map<Character,Integer>map = getCount(letters);
        backTrack(words,score,map,0,0);
        return max;
    }
}