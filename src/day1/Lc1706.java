package day1;

public class Lc1706 {


    public int[] findBall(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        int[] res = new int[columns];

        int count = 0;
        int row = 0;
        int col = 0;
        while(count < columns) {
            row = 0;
            col = count;

            while(row < rows && row >= 0 && col < columns && col >= 0) {

                //主要是对于条件的梳理以及判断
                int nextCol = col + grid[row][col];
                if(nextCol < 0 || nextCol > grid[0].length - 1 || grid[row][col] != grid[row][nextCol]) {
                    res[count] = -1;
                    break;
                }

                if(grid[row][col] == 1) {
                    row = row + 1;
                    col = col + 1;
                } else {
                    row = row + 1;
                    col = col - 1;
                }
            }
            if(row != rows) {
                res[count] = -1;
            } else {
                res[count] = col;
            }

            count ++;
        }

        return res;
    }

    // 官方答案：dfs
    public int[] findBall2(int[][] grid) {
        int[] res = new int[grid[0].length];
        for(int i = 0; i < grid[0].length; i++) {
            res[i] = findBallDropColumn(0, i, grid);
        }

        return res;
    }

    private int findBallDropColumn(int row, int col, int[][] grid) {
        // base case
        if(row == grid.length) {
            return col;
        }

        int nextCol = col + grid[row][col];
        if (nextCol < 0 ||
                nextCol > grid[0].length - 1 ||
                grid[row][col] != grid[row][nextCol]) {
            return -1;
        }

        return findBallDropColumn(row+1, nextCol, grid);
    }

}
