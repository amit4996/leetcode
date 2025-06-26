class Solution {
    public void solve(char[][] board) {

        int m=board.length;
        int n=board[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i==m-1 || j==n-1) && board[i][j] == 'O'){
                  q.offer(new int[]{i,j});
                }
            }
        }

        int[][] dirs = {{0,-1},{0,1},{1,0},{-1,0}};
        while(!q.isEmpty()){
           int[] current=q.poll();
           board[current[0]][current[1]]='T';
           for(int i=0;i<4;i++){
                int ri=current[0]+dirs[i][0];
                int ci=current[1]+dirs[i][1];
                if(ri>=0 && ri<m && ci>=0 && ci<n && board[ri][ci]=='O'){
                   board[ri][ci]='T';
                   q.offer(new int[]{ri,ci});
                }
           } 
        }

        System.out.println(board);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }

    }
}