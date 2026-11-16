class Solution {
    public String digitSum(String s, int k) {
        
        StringBuilder sb = new StringBuilder(s);
        while(sb.length() > k){
            StringBuilder val = new StringBuilder();
           
            int num = 0;
            for(int i = 0; i < sb.length(); i++){
                num += sb.charAt(i) - '0';
                if((i + 1)% k == 0 || sb.length() - 1 == i){
                    val.append(num);
                    num = 0;
                }
                
            }
            sb = new StringBuilder(val.toString());
        }
        return sb.toString();
    }
}