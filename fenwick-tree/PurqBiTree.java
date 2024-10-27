class PurqBiTree {
    int arrayLength;
    long[] tree;

    PurqBiTree(int arrayLength) {
        this.arrayLength = arrayLength;
        tree = new long[arrayLength];
    }

    PurqBiTree(long[] array) {
        arrayLength = array.length;
        tree = new long[arrayLength];
        for (int i = 0; i < array.length; i++) {
            add(i, array[i]);
        }
    }

    // returns sum over slice [0, right]
    long rangeSum(int right) {
        long sum = 0;
        for (; right >= 0; right = (right & (right + 1)) - 1) {
            sum += tree[right];
        }
        return sum;
    }

    // returns sum over slice [left, right]
    long rangeSum(int left, int right) {
        return rangeSum(right) - rangeSum(left - 1);
    }

    void add(int pos, long delta) {
        for (; pos < arrayLength; pos = pos | (pos + 1)) {
            tree[pos] += delta;
        }
    }
}