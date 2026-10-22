class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int k = nums[0];

        boolean asc = true, desc = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (k + i) % n) asc = false;
            if (nums[i] != (((k - i) % n) + n) % n) desc = false;
        }

        int res = Integer.MAX_VALUE;

        if (asc) {
            if (k == 0) res = 0;
            else res = Math.min(n - k, k + 2);
        }

        if (desc) {
            int m = (k + 1) % n;
            int viaReverseFirst = 1 + (m == 0 ? 0 : n - m);
            int viaRotateFirst = m + 1;
            res = Math.min(res, Math.min(viaReverseFirst, viaRotateFirst));
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}