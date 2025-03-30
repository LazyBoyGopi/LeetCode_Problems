class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList();
        int[]lastIdxes = new int[26];
        int len = s.length();
        for(int i=0;i<len;i++){
            lastIdxes[s.charAt(i)-'a'] = i;
        }
        int preIdx = 0;
        int lastIdxTillNow = lastIdxes[s.charAt(0)-'a'];
        int i = 0;
        while(i < len){
            while(i <= lastIdxTillNow){
                lastIdxTillNow = Math.max(lastIdxTillNow,lastIdxes[s.charAt(i++)-'a']);
            }
            ans.add(lastIdxTillNow-preIdx+1);
            preIdx = i;
            if(i < len)
                lastIdxTillNow = lastIdxes[s.charAt(i)-'a'];
        }
        return ans;
    }
}