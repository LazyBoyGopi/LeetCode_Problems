class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> stu = new LinkedList<>();
        for(int ele : students) stu.offer(ele);
        int idx = 0;
        while(idx < sandwiches.length && stu.size() > 0)
        {
            if(sandwiches[idx] == stu.peek())
            {
                idx++;
                stu.poll();
            }
            else{
                int rotationCount = 0;
                while(rotationCount <= stu.size() && stu.peek() != sandwiches[idx])
                {
                    rotationCount++;
                    stu.add(stu.poll());
                }
                if(rotationCount > stu.size()) break;
            }
        }
        return stu.size();
    }
}