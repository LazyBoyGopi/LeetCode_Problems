class Solution {
    public String clearStars(String s) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Character> q = new PriorityQueue();
        for(char ch : s.toCharArray()){
            if(ch == '*'){
                if(q.size() == 0) continue;
                char temp = q.poll();
                for(int i=sb.length()-1;i>=0;i--){
                    if(sb.charAt(i) == temp) {
                        sb.deleteCharAt(i);
                        break;
                    }
                }
            }
            else {
                sb.append(ch);
                q.add(ch);
            }
        }
        return sb.toString();
    }
}