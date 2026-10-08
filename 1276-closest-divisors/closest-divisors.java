class Solution {
    public int[] closestDivisors(int num) {
        int first = num + 1;
        int second = num + 2;

        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();

        for(int i = 1; i * i <= first; i++){
            if(first % i == 0){
                int pair = first / i;
                if(i * pair == first);
                list1.add(new int[]{i, pair});
            }
        }

        for(int i = 1; i * i <= second; i++){
            if(second % i == 0){
                int pair = second / i;
                if(i * pair == second)
                list2.add(new int[]{i, pair});
            }
        }

        int[] arr1 = new int[2];
        int[] arr2 = new int[2];

        int diff1 = Integer.MAX_VALUE;
        int diff2 = Integer.MAX_VALUE;

        for(int[] arr: list1){
            int d = Math.abs(arr[0] - arr[1]);
            if(d < diff1){
                diff1 = d;
                arr1 = arr;
            }
        }

        for(int[] arr: list2){
            int d = Math.abs(arr[0] - arr[1]);
            if(d < diff2){
                diff2 = d;
                arr2 = arr;
            }
        }

        for(int[] arr : list1)
        System.out.println(Arrays.toString(arr));

        for(int[] arr : list2)
        System.out.println(Arrays.toString(arr));
        
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        System.out.println(diff1 + " " + diff2);

        if(diff1 < diff2) return arr1;
        else return arr2;
    }
}