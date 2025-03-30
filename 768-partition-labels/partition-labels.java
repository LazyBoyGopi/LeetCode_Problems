class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList();
        int len = s.length(), preIdx = 0, i = 0, lastIdxTillNow = s.lastIndexOf(s.charAt(0));
        while(i < len){
            while(i <= lastIdxTillNow){
                lastIdxTillNow = Math.max(lastIdxTillNow,s.lastIndexOf(s.charAt(i++)));
            }
            ans.add(lastIdxTillNow-preIdx+1);
            preIdx = i;
            if(i < len)
                lastIdxTillNow = s.lastIndexOf(s.charAt(i));
        }
        return ans;
    }
}