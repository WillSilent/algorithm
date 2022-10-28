package algorithm.search.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LC200NumbersOfIsland {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //boolean[][] visited = new boolean[m][n];
        int numIslands = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    numIslands ++;

                    grid[i][j] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(i * n + j);

                    while(!neighbors.isEmpty()) {
                        int identity = neighbors.remove();
                        int row = identity / n;
                        int col = identity % n;

                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * n + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < m && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * n + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * n + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < n && grid[row][col+1] == '1') {
                            neighbors.add(row * n + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return numIslands;
    }
}
