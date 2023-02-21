package algorithm.search.DFS;

import java.util.HashSet;
import java.util.Set;

/**
 * LC200的变种，就只是需要进行一个转换，本质还是dfs
 */
public class LC694NumberOfDistinctIslands {
    int[][] grid;
    int m, n;
    int baseRow, baseCol;
    Set<String> set = new HashSet<>();
    public int numDistinctIslands(int[][] grid) {
        // use the DFS to search every islands
        // each island transforms into a string
        // and then use a hashset to record those strings
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    continue;
                }

                baseRow = i;
                baseCol = j;
                StringBuilder s = new StringBuilder();
                dfs(i, j, s);
                set.add(s.toString());
            }
        }

        return set.size();
    }

    private void dfs(int i, int j, StringBuilder s) {

        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return;
        }

        s.append(i - baseRow);
        s.append(j - baseCol);
        grid[i][j] = 0;

        // up
        dfs(i-1, j, s);

        // right
        dfs(i, j + 1, s);

        // down
        dfs(i + 1, j , s);

        // left
        dfs(i, j - 1, s);
    }
}
