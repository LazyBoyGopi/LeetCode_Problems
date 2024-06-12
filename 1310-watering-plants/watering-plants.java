class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int curWater = capacity , steps = 0;
        for(int i=0;i<plants.length;i++){
            if(curWater < plants[i]){
                steps += (i*2);
                curWater = capacity;
            }
            curWater -= plants[i];
            steps++;
        }
        return steps;
    }
}