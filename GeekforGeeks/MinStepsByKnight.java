class Solution {
    public int minStepToReachTarget(int knightPos[],int targetPos[],int n) {
        int[][] d={{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
        boolean[][] vis=new boolean[n][n];
        Queue<int[]> q=new ArrayDeque<>();

        int sx=knightPos[0]-1,sy=knightPos[1]-1;
        int tx=targetPos[0]-1,ty=targetPos[1]-1;

        q.add(new int[]{sx,sy,0});
        vis[sx][sy]=true;

        while(!q.isEmpty()){
            int[] cur=q.poll();
            int x=cur[0],y=cur[1],steps=cur[2];

            if(x==tx&&y==ty) return steps;

            for(int[] move:d){
                int nx=x+move[0],ny=y+move[1];

                if(nx>=0&&nx<n&&ny>=0&&ny<n&&!vis[nx][ny]){
                    vis[nx][ny]=true;
                    q.add(new int[]{nx,ny,steps+1});
                }
            }
        }

        return -1;
    }
}