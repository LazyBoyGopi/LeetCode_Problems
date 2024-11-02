class Solution {
    public boolean isCircularSentence(String sentence) {
        String[]ar = sentence.split(" ");
        for(int i=1;i<ar.length;i++){
            String last = ar[i-1], cur = ar[i];
            if(last.charAt(last.length()-1) != cur.charAt(0)) return false;
        }
        String last = ar[ar.length-1], first = ar[0];
        return last.charAt(last.length()-1) == first.charAt(0);
    }
}