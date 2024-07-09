class Solution {
    public double averageWaitingTime(int[][] customers) {
        double total = customers[0][1];
        int busyTill = customers[0][0]+customers[0][1];
        for(int i=1;i<customers.length;i++){
            if(customers[i][0] < busyTill){
                total += busyTill-customers[i][0];
                busyTill += customers[i][1];
            }else{
                busyTill = customers[i][0]+customers[i][1];
            }
            total += customers[i][1];
        }
        return (double)total/(double)customers.length;
    }
}