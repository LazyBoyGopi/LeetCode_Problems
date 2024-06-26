class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int low = 0 , high = people.length-1 , count = 0;
        while(low < high)
        {
            if(people[low] + people[high] <= limit) low++;
            high--;
            count++;
        }
        return low == high ? ++count : count;
    }
}