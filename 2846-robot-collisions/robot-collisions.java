import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        
        Arrays.sort(order, (a, b) -> Integer.compare(positions[a], positions[b]));
        
        Deque<Integer> stack = new ArrayDeque<>(); 
        
        for (int i : order) {
            if (directions.charAt(i) == 'R') {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && healths[i] > 0) {
                    int j = stack.peek();
                    
                    if (healths[j] < healths[i]) {
                        healths[j] = 0; // Mark right-moving robot as destroyed
                        stack.pop();
                        healths[i]--;
                    } else if (healths[j] == healths[i]) {
                        healths[j] = 0; // FIX: Mark right-moving robot as destroyed
                        healths[i] = 0; // Mark left-moving robot as destroyed
                        stack.pop();
                    } else {
                        healths[j]--;   // Right-moving robot survives but loses 1 health
                        healths[i] = 0; // Left-moving robot is destroyed
                    }
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }
        }
        
        return result;
    }
}
