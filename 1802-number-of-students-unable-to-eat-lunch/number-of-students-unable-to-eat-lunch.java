class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> stu = new ArrayDeque<>();
        for(int ele : students) stu.offer(ele);
        int idx = 0;
        while(idx < sandwiches.length && stu.size() > 0)
        {
            if(sandwiches[idx] == stu.peek())
            {
                idx++;
                stu.remove();
            }
            else{
                int rotationCount = 0;
                while(stu.size() > 0 && rotationCount <= stu.size() && stu.peek() != sandwiches[idx])
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