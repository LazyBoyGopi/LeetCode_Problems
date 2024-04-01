class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total = 0;
        int rem = 0;
        while(rem + numBottles >= numExchange)
        {
            total += numBottles;
            rem = (rem+numBottles)-numExchange;
            numExchange++;
            numBottles = 1;
        }
        return total + numBottles;
    }
}