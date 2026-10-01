class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < routes.length; i++){
            for(int stop : routes[i]){
                if(!map.containsKey(stop)){
                    map.put(stop, new ArrayList<>());
                }
                map.get(stop).add(i);
            }
        } 
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[routes.length];
        for(int bus: map.getOrDefault(source, new ArrayList<>())){
            queue.offer(new int[] {bus, 1});
            visited[bus] = true;
        }

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int bus =  current[0];
            int count = current[1];

            for(int stop : routes[bus]){
                if(stop == target){
                    return count;
                }

                for(int nextBus : map.get(stop)){
                    if(!visited[nextBus]){
                        visited[nextBus] = true;
                        queue.offer(new int[]{nextBus, count + 1});
                    }
                }
            }
        }
        



return -1;
    }
}