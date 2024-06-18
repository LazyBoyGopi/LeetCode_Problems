class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int playersIdx = 0 , trainersIdx = 0 , n = players.length , m = trainers.length;
        while(playersIdx < n && trainersIdx < m){
            if(trainers[trainersIdx] >= players[playersIdx])
                playersIdx++;
            trainersIdx++;
        }
        return playersIdx;
    }
}