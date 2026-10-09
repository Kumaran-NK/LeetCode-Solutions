class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return n;
        if(n == 2) return 2;
        int step1 = 1;
        int step2 = 2;
        for(int i = 2; i < n; i++){
            int climb = step1 + step2;
            step1 = step2;
            step2 = climb;
        }
        return step2;
    }
}