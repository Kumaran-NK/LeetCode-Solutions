class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        List<int[]> result = new ArrayList<>();
        for(int[] arr : restaurants){
            if(veganFriendly == 1){
                if(arr[2] == 1 && arr[3] <= maxPrice && arr[4] <= maxDistance){
                    result.add(arr);
                }
            }
            else{
                if(arr[3] <= maxPrice && arr[4] <= maxDistance){
                    result.add(arr);
                }
            }
        }
       
        result.sort((a, b) -> { if(a[1] != b[1]) return Integer.compare(b[1], a[1]); else return Integer.compare(b[0], a[0]);});

        List<Integer> filtered = new ArrayList<>();
        for(int[] arr : result){
            filtered.add(arr[0]);
        }

        return filtered;
        
    }
}