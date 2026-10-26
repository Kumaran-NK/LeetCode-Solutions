class Solution {
    public boolean lemonadeChange(int[] bills) {
        int cash5 = 0;
        int cash10 = 0;
        for(int bill : bills){
            if(bill == 5){
                cash5 += 1;
            }
            else if(bill == 10){
                if(cash5 <= 0) return false;
                cash5 -= 1;
                cash10 += 1;
            }
            else if(bill == 20){
                
                if(cash10 >= 1 && cash5 >= 1){
                    cash10 -= 1;
                    cash5 -= 1;
                }
                else if(cash5 >= 3){
                    cash5 -= 3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}