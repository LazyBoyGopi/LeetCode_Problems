class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int count = 0;
        int playersIdx = 0 , trainersIdx = 0 , n = players.length , m = trainers.length;
        for(int i=0;playersIdx < n && trainersIdx < m;){
            if(trainers[trainersIdx] >= players[playersIdx])
                {
                    playersIdx++;
                    count++;
                }
            trainersIdx++;
        }
        return count;
    }
}