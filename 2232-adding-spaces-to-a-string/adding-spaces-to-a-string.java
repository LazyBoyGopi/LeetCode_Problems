class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int curIdx = 0, spacesIdx = 0, len = s.length(),spacesLen = spaces.length;

        while(curIdx < len){  
            if(spacesIdx < spacesLen && curIdx == spaces[spacesIdx]){
                sb.append(" ");
                spacesIdx++;
            }
            sb.append(s.charAt(curIdx));
            curIdx++;
        }
        return sb.toString();
    }
}