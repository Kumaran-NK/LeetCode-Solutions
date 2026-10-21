class Solution {
    public int minOperations(String s) {
        boolean sorted = true;
        char max = s.charAt(0);
        char min = s.charAt(0);

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) < s.charAt(i - 1)) sorted = false;

            min = (char) Math.min(min, s.charAt(i));
            max = (char) Math.max(max, s.charAt(i));
        }

        if(sorted == true) return 0;

        if(s.length() == 2) return -1;

        if(s.charAt(0) == min || s.charAt(s.length() - 1) == max) return 1;

        for(int i = 1; i < s.length() - 1; i++){
            if(s.charAt(i) == min || s.charAt(i) == max) return 2;
        }
        return 3;
    }
}