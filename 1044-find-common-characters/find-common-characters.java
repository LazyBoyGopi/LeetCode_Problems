class Solution {
    public List<String> commonChars(String[] words) {
        List<int[]> freqList = new LinkedList<>();
        for(int i=0;i<words.length;i++){
            int[]freq = new int[26];
            for(int j=0;j<words[i].length();j++){
                freq[words[i].charAt(j)-'a']++;
            }
            freqList.add(freq);
        }
        List<String> ans = new LinkedList<>();
        for(int i=0;i<=25;i++){
            int min = 101;
            for(int[] ar : freqList){
                if(ar[i] != 0)
                {
                    min = Math.min(min,ar[i]);
                }
                else {
                    min = 101;
                    break;
                }
            }
            if(min != 101){
                for(int j=0;j<min;j++){
                ans.add(Character.toString(i+'a'));
            }
            }
        }
        return ans;
    }
}