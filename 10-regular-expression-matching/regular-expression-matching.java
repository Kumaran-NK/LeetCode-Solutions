class Solution {
    public boolean isMatch(String s, String p) {
        return matching(s, s.length() - 1, p, p.length() - 1);
    }

    public boolean matching(String s, int i, String p, int j){

        if(j < 0) return i < 0;
        if(i < 0){
            if(p.charAt(j) == '*'){
                return matching(s, i, p, j - 2);
            }
            return false;
        }


        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
            return matching(s, i - 1, p, j - 1);
        }

        if(p.charAt(j) == '*'){
            boolean zero = matching(s, i, p, j - 2);
            boolean more = (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && matching(s, i - 1, p, j);

            return zero || more;
        
        }

        return false;

    }
}