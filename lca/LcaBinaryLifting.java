class LcaBinaryLifting {
    int nodeCount, root, logBound, timer;
    int[] depth, tin, tout;
    int[][] up;
    List<List<Integer>> adj;

    LcaBinaryLifting(int nodeCount, int root, List<List<Integer>> adj) {
        this.nodeCount = nodeCount;
        this.root = root;
        logBound = 0;
        while ((1 << (logBound++)) < nodeCount);
        timer = 0;

        depth = new int[nodeCount];
        tin = new int[nodeCount];
        tout = new int[nodeCount];
        up = new int[nodeCount][logBound];
        this.adj = adj;

        dfs(root, root);
    }

    private void dfs(int v, int p) {
        tin[v] = ++timer;
        up[v][0] = p;
        depth[v] = depth[p] + 1;

        for (int i = 1; i < logBound; i++) {
            up[v][i] = up[up[v][i-1]][i-1];
        }

        for (int u : adj.get(v)) {
            if (u != p) {
                dfs(u, v);
            }
        }

        tout[v] = ++timer;
    }

    int getKthAncestor(int u, int k) {
        for (int i = 0; i < logBound; i++) {
            if (((1 << i) & k) > 0) {
                u = up[u][i];
            }
        }
        return u;
    }

    private boolean isAncestor(int u, int v) {
        return tin[u] <= tin[v] && tout[v] <= tout[u];
    }

    int lca(int u, int v) {
        if (isAncestor(u, v)) {
            return u;
        } else if (isAncestor(v, u)) {
            return v;
        } else {
            for (int i = logBound - 1; i >= 0; i--) {
                if (!isAncestor(up[u][i], v)) {
                    u = up[u][i];
                }
            }
            return up[u][0];
        }
    }
}