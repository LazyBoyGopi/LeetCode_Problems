class Solution {
    private int K;
    private String checkAllPossibilites(int n,int k,StringBuilder sb){
        if(sb.length() == n){
            K++;
            return K == k ? sb.toString() : "";
        }
        if(sb.charAt(sb.length()-1) == 'a'){
            sb.append('b');
            String s = checkAllPossibilites(n,k,sb);
            if(s.length() != 0){
                return s;
            }
            sb.setLength(sb.length()-1);
            sb.append('c');
            s = checkAllPossibilites(n,k,sb);
            if(s.length() != 0){
                return s;
            }
            sb.setLength(sb.length()-1);
        }else if(sb.charAt(sb.length()-1) == 'b'){
            sb.append('a');
            String s = checkAllPossibilites(n,k,sb);
            if(s.length() != 0){
                return s;
            }
            sb.setLength(sb.length()-1);
            sb.append('c');
            s = checkAllPossibilites(n,k,sb);
            if(s.length() != 0){
                return s;
            }
            sb.setLength(sb.length()-1);
        }else{
            sb.append('a');
            String s = checkAllPossibilites(n,k,sb);
            if(s.length() != 0){
                return s;
            }
            sb.setLength(sb.length()-1);
            sb.append('b');
            s = checkAllPossibilites(n,k,sb);
            if(s.length() != 0){
                return s;
            }
            sb.setLength(sb.length()-1);
        }
        return "";

    }
    public String getHappyString(int n, int k) {
        K = 0;
        String s = checkAllPossibilites(n,k,new StringBuilder().append('a'));
        if(s.length() != 0){
            return s;
        }
        s = checkAllPossibilites(n,k,new StringBuilder().append('b'));
        if(s.length() != 0){
            return s;
        }
        return checkAllPossibilites(n,k,new StringBuilder().append('c'));
    }
}