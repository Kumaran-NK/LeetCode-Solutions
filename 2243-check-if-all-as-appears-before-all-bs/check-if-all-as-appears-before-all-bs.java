class Solution {
    public boolean checkString(String s) {
        if(s.length() == 0) return false;
        if(s.length() == 1) return true;
        if(s.length() == 2 && s.charAt(0) == 'a' && s.charAt(1) == 'b') return true;
        else if(s.charAt(0) == 'b' && s.charAt(1) == 'a') return false;
    
        boolean flag = false;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) != s.charAt(i) && flag) return false;
            if(s.charAt(i - 1) != s.charAt(i)){
                flag =  true;
            }
        }
        return true;
    }
}