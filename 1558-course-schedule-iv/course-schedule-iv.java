/**
class Solution {
    
    private Set<Integer> getAllPrerequisitesFor(int num,int[][]prerequisites,Set<Integer>set){
        for(int i=0;i<prerequisites.length;i++){
            if(prerequisites[i][0] == num){
                set.add(prerequisites[i][1]);
                getAllPrerequisitesFor(prerequisites[i][1],prerequisites,set);
            }
        }
        return set;
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int qLen = queries.length;
        Set<Integer>[] set = (Set<Integer>[])new Set<?> [numCourses];
        for(int i=0;i<numCourses;i++){
            set[i] = getAllPrerequisitesFor(i,prerequisites,new HashSet());
        }
        System.out.println(Arrays.toString(set));
        List<Boolean>list = new ArrayList<Boolean>();
        for(int i=0;i<qLen;i++){
            list.add(set[queries[i][0]].contains(queries[i][1]));
        }
        return list;

    }
}
 */


import java.util.*;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Step 1: Create a reachability matrix
        boolean[][] reachable = new boolean[numCourses][numCourses];

        // Step 2: Populate the matrix with direct prerequisites
        for (int[] prereq : prerequisites) {
            reachable[prereq[0]][prereq[1]] = true;
        }

        // Step 3: Compute transitive closure using Floyd-Warshall
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    reachable[i][j] = reachable[i][j] || (reachable[i][k] && reachable[k][j]);
                }
            }
        }

        // Step 4: Process queries
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(reachable[query[0]][query[1]]);
        }

        return result;
    }
}
