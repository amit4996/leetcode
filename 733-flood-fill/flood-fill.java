class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int original=image[sr][sc];
        if(original == color) return image;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        
        int[] x={0,0,1,-1};
        int[] y={1,-1,0,0};

        while(!q.isEmpty()){
            int[] current=q.poll();
            int currentx=current[0];
            int currenty=current[1];
            image[currentx][currenty]=color;
            for(int i=0;i<4;i++){
                int xi=currentx+x[i];
                int yi=currenty+y[i];
                if(xi>=0 && yi>=0 && xi<m && yi<n && image[xi][yi]==original){
                    q.offer(new int[]{xi,yi});
                }
            }
        }

        return image;
    }
}