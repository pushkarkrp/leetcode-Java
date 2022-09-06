class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        solve(graph, 0, result, path);
        return result;
    }
    
    public void solve(int[][] graph, int index, List<List<Integer>> result, List<Integer> path) {
        if (index == graph.length - 1) {
            result.add(new ArrayList(path));
            return;
        }
        for (int n : graph[index]) {
            path.add(n);
            solve(graph, n, result, path);
            path.remove(path.size()-1);
        }
    }
}