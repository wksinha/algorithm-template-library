class DisjointSetUnion<T> {
    Map<T, T> parent;
    Map<T, Integer> size;

    DisjointSetUnion() {
        parent = new HashMap<>();
        size = new HashMap<>();
    }

    DisjointSetUnion(int capacity) {
        parent = new HashMap<>(capacity);
        size = new HashMap<>(capacity);
    }

    DisjointSetUnion(T[] init) {
        parent = new HashMap<>(init.length);
        size = new HashMap<>(init.length);
        for (var key : init) {
            parent.put(key, key);
            size.put(key, 1);
        }
    }

    void add(T key) {
        parent.putIfAbsent(key, key);
        size.putIfAbsent(key, 1);
    }

    int keySize(T key) {
        return size.get(key);
    }

    T find(T key) {
        T par = parent.get(key);
        if (par.equals(key)) {
            return key;
        } else {
            par = find(par);
            parent.put(key, par);
            return par;
        }
    }

    void merge(T a, T b) {
        T parA = find(a);
        T parB = find(b);

        if (!parA.equals(parB)) {
            int sizParA = size.get(parA);
            int sizParB = size.get(parB);
            int newSize = sizParA + sizParB;

            if (sizParA >= sizParB) {
                parent.put(parB, parA);
                size.put(parA, newSize);
            } else {
                parent.put(parA, parB);
                size.put(parB, newSize);
            }
        }
    }
}