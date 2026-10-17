class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids){
            if(asteroid < 0){
                while(!stack.isEmpty() && stack.peek() > 0){
                    if(stack.peek() < -asteroid){
                        stack.pop();
                    }
                    else if(stack.peek() == -asteroid){
                        stack.pop();
                        asteroid = 0;
                        break;
                    }
                    else{
                        asteroid = 0;
                        break;
                    }
                }
                if(asteroid != 0) stack.push(asteroid);
            }
            else{
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--){
            result[i] = stack.pop();
        }

        return result;
    }
}