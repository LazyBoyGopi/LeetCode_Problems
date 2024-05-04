class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int low = 0 , high = people.length-1 , count = 0;
        while(low < high)
        {
            count++;
            if(people[low] + people[high] <= limit){
                low++;
                high--;
            }
            else high--;
        }
        return low == high ? ++count : count;
    }
}