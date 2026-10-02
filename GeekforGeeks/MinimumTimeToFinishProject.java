class Solution {
    public int minTime(int[] duration,int[][] dependencies) {
        int n=duration.length;
        ArrayList<Integer>[] g=new ArrayList[n];
        int[] indegree=new int[n];

        for(int i=0;i<n;i++) g[i]=new ArrayList<>();

        for(int[] e:dependencies){
            int u=e[0],v=e[1];
            g[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> q=new ArrayDeque<>();
        int[] finish=new int[n];

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
                finish[i]=duration[i];
            }
        }

        int count=0,ans=0;

        while(!q.isEmpty()){
            int u=q.poll();
            count++;
            ans=Math.max(ans,finish[u]);

            for(int v:g[u]){
                finish[v]=Math.max(finish[v],finish[u]+duration[v]);
                indegree[v]--;

                if(indegree[v]==0)
                    q.add(v);
            }
        }

        return count==n?ans:-1;
    }
}