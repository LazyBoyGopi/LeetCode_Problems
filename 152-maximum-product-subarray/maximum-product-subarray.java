class Solution {
    public int maxProduct(int[] nums) {
        int prod = 1 , maxProd = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            prod = 1;
            for(int j=i;j<nums.length;j++)
            {
                prod *= nums[j];
                maxProd = Math.max(maxProd,prod);
            }
        }
        return maxProd;
    }
}