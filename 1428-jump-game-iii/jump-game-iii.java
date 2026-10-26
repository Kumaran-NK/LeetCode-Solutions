class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return reach(arr, start, visited);
    }

    public boolean reach(int[] arr, int i, boolean[] visited){
        if(i < 0 || i >= arr.length || visited[i]) return false;

        if(arr[i] == 0) return true;

        visited[i] = true;
        boolean forward = reach(arr, i + arr[i], visited);
        boolean backward = reach(arr, i - arr[i], visited);

        return forward || backward;
    }
}