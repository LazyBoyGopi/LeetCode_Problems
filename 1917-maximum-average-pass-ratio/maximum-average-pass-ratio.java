import java.util.PriorityQueue;

class Solution {
    private class Pair {
        double gain; // The gain in passing ratio if a student is added
        int idx;     // Index of the class
        
        public Pair(double _gain, int _idx) {
            gain = _gain;
            idx = _idx;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Priority queue to maximize the "gain" when adding a student
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> Double.compare(b.gain, a.gain));

        int len = classes.length;

        // Initialize the queue with the initial gains for each class
        for (int i = 0; i < len; i++) {
            int pass = classes[i][0];
            int total = classes[i][1];
            double gain = calculateGain(pass, total);
            queue.offer(new Pair(gain, i));
        }

        // Distribute extra students
        while (extraStudents > 0) {
            Pair pair = queue.poll(); // Get the class with the max gain
            int idx = pair.idx;

            // Update the class by adding one student
            classes[idx][0]++;
            classes[idx][1]++;
            
            // Recalculate gain and re-add to the queue
            double newGain = calculateGain(classes[idx][0], classes[idx][1]);
            queue.offer(new Pair(newGain, idx));

            extraStudents--;
        }

        // Calculate the final average passing ratio
        double averageRatio = 0.0;
        for (int i = 0; i < len; i++) {
            averageRatio += (double) classes[i][0] / classes[i][1];
        }

        averageRatio /= len;

        // Round to 5 decimal places
        return Math.round(averageRatio * 100000.0) / 100000.0;
    }

    // Function to calculate gain after adding one student
    private double calculateGain(int pass, int total) {
        double before = (double) pass / total;
        double after = (double) (pass + 1) / (total + 1);
        return after - before;
    }
}
