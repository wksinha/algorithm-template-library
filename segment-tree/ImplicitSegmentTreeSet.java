class ImplicitSegmentTreeSet {
    private static final int DEFAULT_START = Integer.MIN_VALUE;
    private static final int DEFAULT_END = Integer.MAX_VALUE;
    ImplicitSegmentTreeNode root;

    class ImplicitSegmentTreeNode {
        int start, end;
        ImplicitSegmentTreeNode leftChild;
        ImplicitSegmentTreeNode rightChild;
    
        ImplicitSegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            leftChild = null;
            rightChild = null;
        }
    }

    ImplicitSegmentTreeSet() {
        this.root = new ImplicitSegmentTreeNode(DEFAULT_START, DEFAULT_END);
    }

    ImplicitSegmentTreeSet(int start, int end) {
        this.root = new ImplicitSegmentTreeNode(start, end);
    }

    boolean contains(int key) {
        ImplicitSegmentTreeNode curr = root;
        while (curr != null && curr.start < curr.end) {
            int mid = (curr.start + curr.end) >> 1;
            if (key <= mid) {
                curr = curr.leftChild;
            } else {
                curr = curr.rightChild;
            }
        }
        return curr != null;
    }

    void add(int key) {
        ImplicitSegmentTreeNode curr = root;
        while (curr != null && curr.start < curr.end) {
            int mid = (curr.start + curr.end) >> 1;
            if (key <= mid) {
                if (curr.leftChild == null) {
                    curr.leftChild = new ImplicitSegmentTreeNode(curr.start, mid);
                }
                curr = curr.leftChild;
            } else {
                if (curr.rightChild == null) {
                    curr.rightChild = new ImplicitSegmentTreeNode(mid + 1, curr.end);
                }
                curr = curr.rightChild;
            }
        }
    }
}