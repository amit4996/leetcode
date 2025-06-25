class Solution {
    public int findCircleNum(int[][] isConnected) {
        int noofNode=isConnected[0].length;
        boolean visited[] = new boolean[noofNode];
        int count=0;
        for(int i=0;i<noofNode;i++)
        {
                if(!visited[i]){
                bfs(isConnected,visited,i);
                count++;
                }
        }
        return count;
    }

    public void bfs(int[][] isConnected,boolean[] visited,int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            Integer val = q.poll();
            visited[val]=true;

            int[] arr=isConnected[val];

            for(int i=0;i<arr.length;i++){
                if(arr[i]==1 && !visited[i]){
                    q.offer(i);
                }
            }
        }

    }
}