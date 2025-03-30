class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList();
        int[][]range = new int[26][2];
        for(int [] r : range){
            r[0] = -1;
        }
        int len = s.length();
        for(int i=0;i<len;i++){
            int curIdx = s.charAt(i)-'a';
            if(range[curIdx][0] != -1){
                range[curIdx][1] = i;
            }else{
                range[curIdx][0] = range[curIdx][1] = i; 
            }
        }
        int preIdx = 0;
        int lastIdxTillNow = range[s.charAt(0)-'a'][1];
        int i = 0;
        while(i < len){
            while(i <= lastIdxTillNow){
                lastIdxTillNow = Math.max(lastIdxTillNow,range[s.charAt(i)-'a'][1]);
                i++;
            }
            ans.add(lastIdxTillNow-preIdx+1);
            preIdx = i;
            if(i < len)
                lastIdxTillNow = range[s.charAt(i)-'a'][1];
        }
        return ans;
    }
}