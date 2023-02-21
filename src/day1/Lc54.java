package day1;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class Lc54 {

    /**
     * We can move the boundaries towards the center of the matrix after we have traversed a row or a column.
     * Then when we meet a boundary, we know it's time to change the direction and update the boundary.
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int rows = matrix.length, columns = matrix[0].length;

        // represents the boundaries
        int up = 0;
        int left = 0;
        int right = columns - 1;
        int down = rows - 1;

        while (res.size() < rows * columns) {
            // left to right
            for(int col = left; col <= right; col++) {
                res.add(matrix[up][col]);
            }

            // up to down
            for(int row = up + 1; row <= down; row ++) {
                res.add(matrix[row][right]);
            }

            // right to left
            if(up != down) {
                for(int col = right - 1; col >= left; col --) {
                    res.add(matrix[down][col]);
                }
            }

            // down to up
            if(left != right) {
                for(int row = down - 1; row > up; row --) {
                    res.add(matrix[row][left]);
                }
            }

            // update the boundary
            up ++;
            left ++;
            right --;
            down --;
        }


        return res;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        int VISITED = 101;
        int rows = matrix.length;
        int colums = matrix[0].length;

        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}}; // right,down,left,up
        int currentDirection = 0;
        int changeDirection = 0;

        int row = 0;
        int col = 0;
        // begin to traversal
        List<Integer> res = new ArrayList<>();
        res.add(matrix[0][0]);
        matrix[0][0] = VISITED;

        while(changeDirection < 2) {
            while(row + direction[currentDirection][0] >= 0 &&
                    row + direction[currentDirection][0] < rows &&
                    col + direction[currentDirection][1] >= 0 &&
                    col + direction[currentDirection][1] < colums &&
                    matrix[row + direction[currentDirection][0]][col + direction[currentDirection][1]] != VISITED) {

                changeDirection = 0; // remain the same direction
                // calculate the next place that we will be move
                row = row + direction[currentDirection][0];
                col = col + direction[currentDirection][1];

                res.add(matrix[row][col]);
                matrix[row][col] = VISITED;
            }

            // change our direction
            currentDirection = (currentDirection+1) % 4;
            changeDirection ++;
        }

        return res;
    }
}
