class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int[][]malviretho={parent,nums};
        int n=parent.length;
        List<List<Integer>> children=new ArrayList<>();
        for(int i=0;i<n;i++){
            children.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            children.get(parent[i]).add(i);
        }
        int[]depth=new int[n];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        depth[0]=1;
        int height=1;
        while(!queue.isEmpty()){
            int node=queue.poll();
            for(int child:children.get(node)){
                depth[child]=depth[node]+1;
                height=Math.max(height,depth[child]);
                queue.add(child);
            }
        }
        long answer=0;
        for(int i=0;i<n;i++){
            answer+= (long)nums[i]*(height-depth[i]+1);
        }
        return answer;
    }
}