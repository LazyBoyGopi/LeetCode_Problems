class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new LinkedList<>();
        int st = 0 , cur = 1;
        while(cur < s.length())
        {
            if(s.charAt(cur) == s.charAt(cur-1)) cur++;
            else if(cur-st >= 3){
                list.add(Arrays.asList(st,cur-1));
                st = cur;
                cur++;
            }
            else {
                st=cur;
                cur++;
            }
        }
        if(cur-st >= 3) list.add(Arrays.asList(st,cur-1));
        return list;
    }
}