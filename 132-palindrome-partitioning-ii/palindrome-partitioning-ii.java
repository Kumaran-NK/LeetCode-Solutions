class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, - 1);
        return partitioning(s, 0, dp);
    }

    public int partitioning(String s, int start, int[] dp) {
        if (start == s.length()) return 0;
        if(dp[start] != -1){
            return dp[start];
        }

        int min = Integer.MAX_VALUE;

        for (int i = start + 1; i <= s.length(); i++) {
            String val = s.substring(start, i);

            if (palindrome(val)) {
                int cut;

                if (i == s.length()) {
                    cut = 0;
                } else {
                    cut = 1 + partitioning(s, i, dp);
                }

                min = Math.min(min, cut);
                dp[start] = min;
            }
        }

        return min;
    }

    public boolean palindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}