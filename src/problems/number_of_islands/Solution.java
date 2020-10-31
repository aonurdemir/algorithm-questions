package problems.number_of_islands;

class Solution {
    private int[] dr;
    private int[] dc;
    private int R;
    private int C;

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;


        dr = new int[]{-1,1,0,0};
        dc = new int[]{0,0,-1,1};

        R = grid.length;
        C = grid[0].length;

        int count = 0;
        for(int r=0; r < R; r++){
            for(int c=0; c < C; c++){
                if(grid[r][c] == '1'){
                    traverse(grid,r,c);
                    count++;
                }
            }
        }

        return count;
    }

    private void traverse(char[][] grid, int r, int c){
        grid[r][c] = '0';
        for(int i=0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= 0 && nr < R  && nc >=0 && nc < C && grid[nr][nc] == '1'){
                traverse(grid,nr,nc);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ret = s.numIslands(new char[][]{
                {'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}   
        });

        System.out.println(ret);

    }
}