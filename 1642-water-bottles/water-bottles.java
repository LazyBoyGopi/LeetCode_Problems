class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalBottles = 0 , rem =0;
        while(numBottles+rem >= numExchange)
        {
            totalBottles += numBottles;
            numBottles += rem;
            rem = numBottles%numExchange;
            numBottles /= numExchange;
        }
        return totalBottles + numBottles;
    }
}