package algorithm.search.DFS;

public class LC200NumbersOfIsland {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '0' || visited[i][j] ) {
                    continue;
                }

                dfs(i, j, visited, grid);
                ans ++;
            }
        }
        return ans;
    }

    private void dfs(int i, int j, boolean[][] visited, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == '0') {
            return;
        }

        visited[i][j] = true;
        dfs(i - 1, j, visited, grid);
        dfs(i + 1, j, visited, grid);
        dfs(i, j - 1, visited, grid);
        dfs(i, j + 1, visited, grid);
    }

}
