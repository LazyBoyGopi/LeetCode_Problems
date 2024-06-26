class Solution {
    public String restoreString(String s, int[] indices) {
       char[] ar = new char[s.length()];
       for(int i=0; i<indices.length;i++){
        ar[indices[i]] = s.charAt(i);
       }
       return new String(ar);
    }
}