class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 1;
        List<Boolean>ans = new ArrayList<>(candies.length);
        for(int candie : candies) if(maxCandies < candie) maxCandies = candie;
        for(int i=0;i<candies.length;i++)
        {
            if(candies[i] + extraCandies >= maxCandies) {
                ans.add(true);
            }
            else ans.add(false);
        }
        return ans;
    }
}