// 130. Surrounded Regions
// Solved
// Medium
// Topics
// Companies
// You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

// Connect: A cell is connected to adjacent cells horizontally or vertically.
// Region: To form a region connect every 'O' cell.
// Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
// A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.



// Example 1:

// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

// Explanation:


// In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

// Example 2:

// Input: board = [["X"]]

// Output: [["X"]]

 

// Constraints:

// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] is 'X' or 'O'.



class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        // int[][] vis = new int[m][n];
        
        for(int j =0; j<n; j++){
            // 1st and last rows
            if(board[0][j] == 'O')
                dfs(board, 0, j);
            if(board[m-1][j] == 'O')
                dfs(board, m-1, j);
        }

        for(int i =0; i < m; i++){
            // 1st and last columns
            if(board[i][0] == 'O')
                dfs(board, i, 0);
            if(board[i][n-1] == 'O')
                dfs(board, i, n-1);
        }

        // mark the O which are sorrounded by X as X
        for(int i=0; i<m; i++){
            for(int j=0; j<n ;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'Y'){
                    board[i][j] ='O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col){
        int m = board.length;
        int n = board[0].length;

        if( row < 0 || row >=m || col < 0 || col >=n || board[row][col] != 'O')
            return;

        board[row][col] ='Y';   // temp

        dfs(board, row, col-1); // left
        dfs(board, row, col+1); // right
        dfs(board, row-1, col); // up
        dfs(board, row + 1, col); // down
    }
}