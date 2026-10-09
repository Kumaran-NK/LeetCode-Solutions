class Solution {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i : nums){
            for(int j = 2; j * j <= i; j++){
                if(i % j == 0){
                    set.add(j);
                    while(i % j == 0){
                        i /= j;
                    }
                }
            }
            if(i > 1){
                set.add(i);
            }
        }
        System.out.println(set);
        return set.size();
    }
}