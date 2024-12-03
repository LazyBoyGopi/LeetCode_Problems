class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int curIdx = 0, spacesIdx = 0, len = s.length();

        while(curIdx < len){  
            if(spacesIdx < spaces.length && curIdx == spaces[spacesIdx]){
                sb.append(" ");
                spacesIdx++;
            }
            // else{
                sb.append(s.charAt(curIdx));
                curIdx++;
            // }
        }
        return sb.toString();
    }
}