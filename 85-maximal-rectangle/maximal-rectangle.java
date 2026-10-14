class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] arr = new int[col];
        int max = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '1'){
                    arr[j]++;
                }
                else{
                    arr[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(arr));
            System.out.println(Arrays.toString(arr));
        }

        return max;
        
        
    }

     public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i <= heights.length; i++){
            int curr = i == heights.length ? 0 : heights[i];

            while(!stack.isEmpty() && heights[stack.peek()] > curr){
                int val = heights[stack.pop()];
                int left = stack.isEmpty() ? - 1 : stack.peek();

                int width = i - left - 1;
                max = Math.max(max, width * val);
            }

            stack.push(i);
        }
        return max;
    }
}