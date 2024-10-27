class PurqSegmentTree {
    int arrayLength;
    long[] tree;

    PurqSegmentTree(int arrayLength) {
        this.arrayLength = arrayLength;
        tree = new long[arrayLength << 1];
    }

    PurqSegmentTree(long[] array) {
        this.arrayLength = array.length;
        tree = new long[arrayLength << 1];
        for (int i = 0; i < arrayLength; i++) {
            tree[i + arrayLength] = array[i];
        }
        for (int i = arrayLength - 1; i > 0; i--) {
            tree[i] = tree[i << 1] + tree[i << 1 | 1];
        }
    }

    void modify(int pos, long value) {
        for (tree[pos += arrayLength] = value; pos > 1; pos >>= 1) {
            tree[pos >> 1] = tree[pos] + tree[pos ^ 1];
        }
    }

    void change(int pos, long delta) {
        long curr = tree[pos + arrayLength];
        modify(pos, curr + delta);
    }

    // returns sum on slice [left, right)
    long rangeSum(int left, int right) {
        long sum = 0;
        for (left += arrayLength, right += arrayLength; left < right; left >>= 1, right >>= 1) {
            if ((left & 1) > 0) {
                sum += tree[left++];
            }
            if ((right & 1) > 0) {
                sum += tree[--right];
            }
        }
        return sum;
    }
}