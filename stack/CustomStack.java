class CustomStack {
    static final int NOT_FOUND = Integer.MAX_VALUE;
    static int[] getNextCeilingElementsIdx(int[] arr) {
        int[] nextCeilingElementsIdx = new int[arr.length];
        java.util.Stack<java.awt.Point> stack = new java.util.Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek().x <= arr[i]) {
                nextCeilingElementsIdx[stack.pop().y] = i;
            }
            stack.push(new java.awt.Point(arr[i], i));
        }
        while (!stack.isEmpty()) {
            nextCeilingElementsIdx[stack.pop().y] = NOT_FOUND;
        }
        return nextCeilingElementsIdx;
    }
    static int[] getNextFloorElementsIdx(long[] arr) {
        int[] nextFloorElementsIdx = new int[arr.length];
        java.util.Stack<java.awt.Point> stack = new java.util.Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek().x >= arr[i]) {
                nextFloorElementsIdx[stack.pop().y] = i;
            }
            stack.push(new java.awt.Point((int) arr[i], i));
        }
        while (!stack.isEmpty()) {
            nextFloorElementsIdx[stack.pop().y] = NOT_FOUND;
        }
        return nextFloorElementsIdx;
    }
 
    static int[] getPreviousCeilingElementsIdx(int[] arr) {
        int[] previousCeilingElementsIdx = new int[arr.length];
        java.util.Stack<java.awt.Point> stack = new java.util.Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().x <= arr[i]) {
                previousCeilingElementsIdx[stack.pop().y] = i;
            }
            stack.push(new java.awt.Point(arr[i], i));
        }
        while (!stack.isEmpty()) {
            previousCeilingElementsIdx[stack.pop().y] = NOT_FOUND;
        }
        return previousCeilingElementsIdx;
    }
    static int[] getPreviousFloorElementsIdx(long[] arr) {
        int[] previousFloorElementsIdx = new int[arr.length];
        java.util.Stack<java.awt.Point> stack = new java.util.Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().x >= arr[i]) {
                previousFloorElementsIdx[stack.pop().y] = i;
            }
            stack.push(new java.awt.Point((int) arr[i], i));
        }
        while (!stack.isEmpty()) {
            previousFloorElementsIdx[stack.pop().y] = NOT_FOUND;
        }
        return previousFloorElementsIdx;
    }
}