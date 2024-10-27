class PrefixSum {
    private long[] ps;
    
    PrefixSum(long[] arr) {
        ps = new long[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            ps[i + 1] = ps[i] + arr[i];
        }
    }

    PrefixSum(int[] arr) {
        ps = new long[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            ps[i + 1] = ps[i] + arr[i];
        }
    }

    // returns sum for indices in range [0, end)
    private long sum(int end) {
        return ps[end];
    }

    // returns sum for indices in range [start, end)
    long sum(int start, int end) {
        return sum(end) - sum(start);
    }
}
