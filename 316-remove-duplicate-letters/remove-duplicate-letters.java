class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char val = s.charAt(i);
            map.put(val, map.get(val) - 1);

            if(stack.contains(val)) continue;
            
            while(!stack.isEmpty() && stack.peek() > val && map.get(stack.peek()) > 0) stack.pop();
            stack.push(val);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }

        return sb.toString();
    }
}