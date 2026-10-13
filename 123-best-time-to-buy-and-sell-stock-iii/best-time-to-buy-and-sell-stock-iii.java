class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int A = -prices[0];
        int B = Integer.MIN_VALUE;
        int C = Integer.MIN_VALUE;
        int D = Integer.MIN_VALUE;

        for(int price : prices){
            A = Math.max(A, -price);
            B = Math.max(B, A + price);
            C = Math.max(C, B - price);
            D = Math.max(D, C + price);
        }
        return D;
    }
}