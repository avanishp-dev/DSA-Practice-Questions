class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : invocations)
            graph[edge[0]].add(edge[1]);
        boolean[] vis = new boolean[n];
        dfs(k, graph, vis);
        for (int[] edge : invocations) {
            if (!vis[edge[0]] && vis[edge[1]]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) ans.add(i);
                return ans;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
        if (!vis[i]) ans.add(i);
        return ans;
    }
    private void dfs(int u, List<Integer>[] graph, boolean[] vis) {
        if (vis[u]) return;
        vis[u] = true;
        for (int v : graph[u])
        dfs(v, graph, vis);
    }
}