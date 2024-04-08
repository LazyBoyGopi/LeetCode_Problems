class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> stu = new ArrayDeque<>();
        for(int ele : students) stu.offer(ele);
        System.out.println(stu);
        int idx = 0;
        while(idx < sandwiches.length && stu.size() > 0)
        {
            if(sandwiches[idx] == stu.peek())
            {
                System.out.println(stu.remove());
                idx++;
                    System.out.println("if"+stu);

            }
            else{
                int rotationCount = 0;
                while(stu.size() > 0 && rotationCount <= stu.size() && stu.peek() != sandwiches[idx])
                {
                    rotationCount++;
                    stu.add(stu.poll());
                    System.out.println("else"+stu);
                }
                if(rotationCount > stu.size()) break;
            }
            System.out.println(stu);
        }
        return stu.size();
    }
}