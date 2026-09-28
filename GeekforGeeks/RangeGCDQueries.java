class Solution {
    public ArrayList<Integer> processQueries(int[] arr,int[][] queries) {
        int n=arr.length;
        int[] tree=new int[4*n];
        build(arr,tree,1,0,n-1);
        ArrayList<Integer> ans=new ArrayList<>();
        for(int[] q:queries){
            if(q[0]==0){
                ans.add(query(tree,1,0,n-1,q[1],q[2]));
            }else{
                update(tree,1,0,n-1,q[1],q[2]);
            }
        }
        return ans;
    }
    void build(int[] arr,int[] tree,int node,int l,int r){
        if(l==r){
            tree[node]=arr[l];
            return;
        }
        int mid=(l+r)/2;
        build(arr,tree,node*2,l,mid);
        build(arr,tree,node*2+1,mid+1,r);
        tree[node]=gcd(tree[node*2],tree[node*2+1]);
    }
    void update(int[] tree,int node,int l,int r,int idx,int val){
        if(l==r){
            tree[node]=val;
            return;
        }
        int mid=(l+r)/2;
        if(idx<=mid) update(tree,node*2,l,mid,idx,val);
        else update(tree,node*2+1,mid+1,r,idx,val);
        tree[node]=gcd(tree[node*2],tree[node*2+1]);
    }
    int query(int[] tree,int node,int l,int r,int ql,int qr){
        if(ql<=l&&r<=qr) return tree[node];
        if(r<ql||l>qr) return 0;

        int mid=(l+r)/2;
        return gcd(query(tree,node*2,l,mid,ql,qr),
                   query(tree,node*2+1,mid+1,r,ql,qr));
    }
    int gcd(int a,int b){
        while(b!=0){
            int t=a%b;
            a=b;
            b=t;
        }
        return a;
    }
}