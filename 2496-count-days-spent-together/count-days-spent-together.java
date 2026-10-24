class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int[] totalDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int aliceStartMonth = Integer.parseInt(arriveAlice.substring(0, 2));
        int aliceEndMonth = Integer.parseInt(leaveAlice.substring(0, 2));

        int bobStartMonth = Integer.parseInt(arriveBob.substring(0, 2));
        int bobEndMonth = Integer.parseInt(leaveBob.substring(0, 2));

        int aliceStartDate = Integer.parseInt(arriveAlice.substring(3, 5));
        int aliceEndDate = Integer.parseInt(leaveAlice.substring(3, 5));

        int bobStartDate = Integer.parseInt(arriveBob.substring(3, 5));
        int bobEndDate = Integer.parseInt(leaveBob.substring(3, 5));

        int arriveA = aliceStartDate;
        for (int i = 0; i < aliceStartMonth - 1; i++) {
            arriveA += totalDays[i];
        }
        
        int leaveA = aliceEndDate;
        for (int i = 0; i < aliceEndMonth - 1; i++) {
            leaveA += totalDays[i];
        }

        int arriveB = bobStartDate;
        for (int i = 0; i < bobStartMonth - 1; i++) {
            arriveB += totalDays[i];
        }
        
        int leaveB = bobEndDate;
        for (int i = 0; i < bobEndMonth - 1; i++) {
            leaveB += totalDays[i];
        }

        
        int startOverlap = Math.max(arriveA, arriveB); 
        int endOverlap = Math.min(leaveA, leaveB);    

        return Math.max(0, endOverlap - startOverlap + 1);
    }
}