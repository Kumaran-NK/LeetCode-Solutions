
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean alive = true;

            while (alive && asteroid < 0
                    && !stack.isEmpty()
                    && stack.peek() > 0) {

                if (stack.peek() < -asteroid) {
                    stack.pop(); // Top asteroid explodes
                } else if (stack.peek() == -asteroid) {
                    stack.pop(); // Both explode
                    alive = false;
                } else {
                    alive = false; // Current asteroid explodes
                }
            }

            if (alive) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
