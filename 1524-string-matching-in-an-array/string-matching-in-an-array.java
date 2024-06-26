class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String>list = new HashSet<>();
        int len = words.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i == j) continue;
                if(words[i].contains(words[j])) list.add(words[j]);
            }
        }
        return new LinkedList<>(list);
    }
}