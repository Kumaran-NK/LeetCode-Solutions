class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(String s, int start, List<String> list){
        
        if(start == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < s.length(); i++){
            String val = s.substring(start, i + 1);
            if(palindrome(val) == false) continue;
            list.add(val);
            backtrack(s, i + 1, list);
            list.remove(list.size() - 1);
        }
       
    }

    public boolean palindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    
}