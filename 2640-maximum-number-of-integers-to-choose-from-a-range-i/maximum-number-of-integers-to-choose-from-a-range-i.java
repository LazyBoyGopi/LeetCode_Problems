class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer>set = new HashSet();
        for(int bannedEle : banned) set.add(bannedEle);
        int sum = 0, countOfIntegers = 0;
        for(int i=1;i<=n;i++){
            if((sum +i) > maxSum) return countOfIntegers;
            if(!set.contains(i)){
                sum += i;
                countOfIntegers++;
            }
        }
        return countOfIntegers;
    }
}