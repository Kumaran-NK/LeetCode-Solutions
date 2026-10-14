class Solution {
    public int largestRectangleArea(int[] heights) {
        

        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for(int i = 0; i <= heights.length; i++){
            int curr = i == heights.length ? 0 : heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] > curr){
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();

                int width = i - left - 1;

                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }
}