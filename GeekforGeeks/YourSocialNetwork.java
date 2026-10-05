class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int n=arr.length+1;
        for(int i=2;i<=n;i++){
            ArrayList<ArrayList<Integer>> temp=new ArrayList<>();
            int cur=i,dist=1;
            while(cur!=1){
                int parent=arr[cur-2];
                ArrayList<Integer> list=new ArrayList<>();
                list.add(i);
                list.add(parent);
                list.add(dist);
                temp.add(list);
                cur=parent;
                dist++;
            }
            for(int j=temp.size()-1;j>=0;j--)ans.add(temp.get(j));
        }
        return ans;
    }
}