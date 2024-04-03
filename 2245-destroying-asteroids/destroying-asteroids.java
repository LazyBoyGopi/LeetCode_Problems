class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long mass1 = mass;
        for(int ele : asteroids)
        {
            if(mass1 >= ele) mass1 += ele;
            else return false;
        }
        return true;
    }
}