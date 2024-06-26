class Solution {
    public String restoreString(String s, int[] indices) {
       char[] ar = new char[101];
       for(int i=0; i<indices.length;i++){
        ar[indices[i]] = s.charAt(i);
       }
       StringBuilder sb = new StringBuilder();
       for(char ch : ar){
        if(ch >= 'a' && ch <= 'z') sb.append(ch);
       }
       return sb.toString();
    }
}