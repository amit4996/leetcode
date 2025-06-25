class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int []> q= new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(grid[i][j]==2){
                  q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        
        if(fresh==0) return 0;

        int count=0;

        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty() && fresh>0){
            int size=q.size();

            for(int i=0;i<size;i++){
              int[] curr=q.poll();

              for(int j=0;j<4;j++){
               int x=curr[0]+dir[j][0];
               int y=curr[1]+dir[j][1];
               if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==1){
                 grid[x][y]=2;
                 q.offer(new int[]{x,y});
                 fresh--;
               }
              }

            }
            if(!q.isEmpty())
            count++;
        }
        return fresh!=0?-1:count;
    }

   
}