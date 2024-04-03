class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int ele : asteroids)
        {
            if(stack.isEmpty())
            {
                stack.push(ele);
                continue;
            }   
            if(stack.peek() > 0 && ele < 0)
            {
                if(Math.abs(stack.peek()) == Math.abs(ele))
                {
                    stack.pop();
                    continue;
                }
                if(Math.abs(stack.peek()) > Math.abs(ele))
                {
                    continue;
                }
                else{
                    int temp = ele;
                    boolean flag = true;
                    while(!stack.isEmpty() && (stack.peek() > 0 && temp < 0) )
                    {
                        if((Math.abs(stack.peek()) < Math.abs(temp)))
                        {
                            temp = ele;
                            stack.pop();
                        }
                        else if(Math.abs(stack.peek()) == Math.abs(temp)){
                            stack.pop();
                            flag = false;
                            break;
                        }
                        else{
                            temp = stack.pop();
                        }
                    }
                    if(flag)
                    stack.push(temp);
                }
            }
            else stack.push(ele);
        }
        int[]ar = new int[stack.size()];
        for(int i= ar.length-1;i>=0;i--)
        {
            ar[i] = stack.pop();
        }
        return ar;
    }
}