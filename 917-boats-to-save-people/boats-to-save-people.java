class Solution {
    public int numRescueBoats(int[] people, int limit) {
       Arrays.sort(people);
       int count = 0 , low = 0 , high = people.length-1;
       while(low <= high)
       {
            if(low == high) return ++count;
            if(people[low] + people[high] <= limit){
                low++;
                high--;
            }
            else if(people[high] <= limit){
                high--;
            }
            else low++;
            count++;
       } 
       return count;
    }
}