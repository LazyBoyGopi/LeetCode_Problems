class Solution {
    public int maxProductDifference(int[] nums) {
        int smallest = Integer.MAX_VALUE , secondSmallest = Integer.MAX_VALUE , largest = Integer.MIN_VALUE , secondLargest = Integer.MIN_VALUE;
        for(int ele : nums)
        {
            if(ele < smallest)
            {
                secondSmallest = smallest;
                smallest = ele;
            }
            else if( ele < secondSmallest)
            {
                secondSmallest = ele;
            }
            if(ele > largest)
            {
                secondLargest = largest;
                largest = ele;
            }
            else if( ele > secondLargest)
            {
                secondLargest = ele;
            }
        }
        return (largest*secondLargest) - (smallest*secondSmallest);
    }
}