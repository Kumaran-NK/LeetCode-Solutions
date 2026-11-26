class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10) return false;
        if(n == 10) return true;
        int val = 10;
        boolean flag = true;
        while(n >= val){
            n -= val--;
            flag = !flag;
        }
        return !flag;
    }
}