class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> smallest = new PriorityQueue<>() , largest = new PriorityQueue<>(Comparator.reverseOrder());
        int maxLen = 0 , left = 0 , right = 0 , len = nums.length;
        while(right < len){
            smallest.add(nums[right]);
            largest.add(nums[right]);
            if(largest.peek()-smallest.peek() <= limit){
                maxLen = Math.max(maxLen,right-left+1);
            }else{
                while(left <= right && largest.peek()-smallest.peek() > limit){
                    largest.remove((Integer)nums[left]);
                    smallest.remove((Integer)nums[left]);
                    left++;
                }
            }
            right++;
        } 
        return maxLen;
       /* int maxLen = 0 , left = 0 , right = 0 , len = nums.length , max = 0 , min = (int)1e9+1 , maxCount = 0 , minCount = 0;
        PriorityQueue<Integer> smallest = new PriorityQueue<>() , largest = new PriorityQueue<>(Comparator.reverseOrder());
        while(right < len){

            if(max < nums[right]){
                max = nums[right];
                maxCount = 1;
            }else if(max == nums[right]) {
                maxCount++;
            }

            if(min > nums[right]){
                min = nums[right];
                minCount = 1;
            }else if(min == nums[right]){
                minCount++;
            }

            smallest.add(nums[right]);
            largest.add(nums[right]);

            if(max-min <= limit){
                maxLen = Math.max(maxLen,right-left+1);
            }
            else{
                while(left <= right && max-min > limit){
                    if(nums[left] == max){
                        maxCount--;
                        if(maxCount == 0){
                            largest.poll();
                            max = largest.poll();
                            maxCount = 1;
                        }else{
                            largest.remove((Integer)nums[left]);
                        }
                    }
                    if(nums[left] == min){
                        minCount--;
                        if(minCount == 0){
                            smallest.poll();
                            min = smallest.poll();
                            minCount = 1;
                        }else{
                             smallest.remove((Integer)nums[left]);
                        }
                    }
                    left++;
                }
            }
            right++;
        }
        return maxLen; */
    }
}