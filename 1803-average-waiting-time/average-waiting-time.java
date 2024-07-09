class Solution {
    public double averageWaitingTime(int[][] customers) {
        double total = 0;
        int busyTill = -1;
        for(int ar[] : customers){
            if(ar[0] < busyTill){
                total += busyTill-ar[0];
                busyTill += ar[1];
            }else{
                busyTill = ar[0]+ar[1];
            }
            total += ar[1];
        }
        return total/customers.length;
    }
}