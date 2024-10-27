class SparseTable {
    int arrayLength, logBound;
    int[] log;
    int[][] table;

    SparseTable(int[] array) {
        arrayLength = array.length;
        logBound = 0;
        while ((1 << (logBound++)) <= arrayLength);

        log = new int[arrayLength + 1];
        for (int i = 2; i <= arrayLength; i++) {
            log[i] = log[i >> 1] + 1;
        }
        
        table = new int[logBound][arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            table[0][i] = array[i];
        }

        for (int i = 1; i < logBound; i++) {
            for (int j = 0; j + (1 << i) <= arrayLength; j++) {
                table[i][j] = Math.min(table[i - 1][j], table[i - 1][j + (1 << (i - 1))]);
            }
        }
    }

    // min over slice [left, right] both inclusive
    int rangeMin(int left, int right) {
        int i = log[right - left + 1];
        return Math.min(table[i][left], table[i][right - (1 << i) + 1]);
    }
}