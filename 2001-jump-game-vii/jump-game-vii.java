
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        int farthest = 0;

        while (!queue.isEmpty()) {

            int i = queue.poll();

            if (i == n - 1) {
                return true;
            }

            int start = Math.max(i + minJump, farthest + 1);
            int end = Math.min(i + maxJump, n - 1);

            for (int j = start; j <= end; j++) {

                if (s.charAt(j) == '0') {
                    visited[j] = true;
                    queue.offer(j);
                }
            }

            farthest = Math.max(farthest, end);
        }

        return false;
    }
}