class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, - 1);
        return backtrack(s, 0, wordDict, dp);
    }

    public boolean backtrack(String s, int i, List<String> wordDict, int[] dp){
        if(i == s.length()) return true;
        if(dp[i] != -1){
            if(dp[i] == 0) return false;
            if(dp[i] == 1) return true;
        }
        for(String word : wordDict){
            if(s.startsWith(word, i)){
                if(backtrack(s, i + word.length(), wordDict, dp)) {
                    dp[i] = 1;
                    return true;
                } 
            }
        }
        dp[i] = 0;
        return false;
    }
}