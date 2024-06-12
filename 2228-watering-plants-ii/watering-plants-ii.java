class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int low = 0 , high = plants.length-1 , steps = 0;
        int ca = capacityA , cb = capacityB;
        while(low < high){
            if(ca < plants[low]) {
                steps++;
                ca = capacityA;
            }
            if(cb < plants[high]){
                steps++;
                cb = capacityB;
            }
            ca -= plants[low++];
            cb -= plants[high--];
        }
        return (plants.length %2 == 1 && ca < plants[low] && cb < plants[high])? ++steps : steps;
    }
}