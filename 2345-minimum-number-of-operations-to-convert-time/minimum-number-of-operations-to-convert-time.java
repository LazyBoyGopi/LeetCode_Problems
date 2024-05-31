class Solution {
    public int convertTime(String current, String correct) {
        int correctHours = Integer.parseInt(correct.substring(0,2));
        int correctMin = Integer.parseInt(correct.substring(3));

        int currentHours = Integer.parseInt(current.substring(0,2));
        int currentMin = Integer.parseInt(current.substring(3));

        int currentTotalMin = currentHours *60 + currentMin;
        int correctTotalMin = correctHours * 60 + correctMin;

        int total = correctTotalMin - currentTotalMin;

        int count = 0;
        count += total/60;
        total %= 60;

        count += total/15;
        total %= 15;

        count += total/5;
        total %= 5;

        count += total;

        return count;
    }
}