class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        if(!s1[0].equals(s2[0]) && !s1[s1.length-1].equals(s2[s2.length-1])) return false;

        int idx1 = 0, idx2 = 0;

        while(idx1 < s1.length && idx2 < s2.length){
            if(s1[idx1].equals(s2[idx2])) {
                idx1++;
                idx2++;
            }else break;
        }
        if(idx1 == s1.length || idx2 == s2.length) return true;

        idx1 = s1.length-1;
        idx2 = s2.length-1;

        while(idx1 >=0 && idx2 >=0 ){
           if(s1[idx1].equals(s2[idx2])) {
                idx1--;
                idx2--;
            }else break;
        }
        if(idx1 == -1 || idx2 == -1) return true;

        idx1 = 0;
        idx2 = 0;

        int lastIdx1 = s1.length-1;
        int lastIdx2 = s2.length-1;
        while(idx1 <= lastIdx1 && idx2 <= lastIdx2){
            if(s1[idx1].equals(s2[idx2])){
                idx1++;
                idx2++;
            }else break;
        }

        while(idx1 <= lastIdx1 && idx2 <= lastIdx2){
            if(s1[lastIdx1].equals(s2[lastIdx2])){
                lastIdx1--;
                lastIdx2--;
            }else break;
        }

        if(idx1 > lastIdx1 || idx2 > lastIdx2) return true;
        return false;

       /* int lastIdx = s1.length-1;
        boolean checkingStringS1 = true;

        while(idx1 <s1.length && idx2 < s2.length && (checkingStringS1 ? (idx1 <= lastIdx ? true : false):(idx2 <= lastIdx)? true : false)){

        } */
    } 
}