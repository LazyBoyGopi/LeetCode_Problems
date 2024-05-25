// class Solution {
//     private boolean backTrack(String s, Set<String>set,int idx,StringBuilder sb){
//         if(idx >= s.length()) {
//             return sb.toString().equals(s);
//         }
//         for(int i=idx;i<s.length();i++){
//             for(int j=s.length();j>idx;j--){
//                 String temp = s.substring(i,j);
//                 if(set.contains(temp)){
//                     sb.append(temp);
//                     if(backTrack(s,set,j,sb)) return true;
//                     sb.delete(sb.length()-temp.length(),sb.length());
//                 }
//             }
//             return false;
//         }
//         return false;
//     }
//     private boolean checkIfPossible(String s, List<String>wordDict){
//         Set<Character>set = new HashSet<>();
//         for(String str: wordDict){
//             for(char ch : str.toCharArray()){
//                 set.add(ch);
//             }
//         }
//         for(char ch : s.toCharArray())
//         {
//             if(!set.contains(ch)) return false;
//         }
//         return true;
//     }
//     public boolean wordBreak(String s, List<String> wordDict) {
//         if(!checkIfPossible(s,wordDict)) return false;
//         Set<String>set = new HashSet<>(wordDict);
//         return backTrack(s,set,0,new StringBuilder());
//     }
// }
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
