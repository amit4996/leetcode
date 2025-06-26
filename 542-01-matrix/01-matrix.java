class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dist= new int[m][n];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                    dist[i][j]=0;
                }
                else
                {
                    dist[i][j]=Integer.MAX_VALUE;
                }
            }
        }

        int[][] axes={{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.isEmpty()){
            int[] current = q.poll();
            int x= current[0];
            int y=current[1];

            for(int[] axe:axes){
                int xn=x+axe[0];
                int yn=y+axe[1];
                if(xn>=0 && yn>=0 && xn<m && yn<n && dist[xn][yn]>dist[x][y]+1){
                   dist[xn][yn]=dist[x][y]+1;
                   q.offer(new int[]{xn,yn});
                }
            }
        }

        return dist;
    }
}