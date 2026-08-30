class Solution {
    class Node {
        int pre,suf,mx,len;
        char lc,rc;
        Node(int len,int pre,int suf,int mx,char lc,char rc){
            this.len=len;
            this.pre=pre;
            this.suf=suf;
            this.mx=mx;
            this.lc=lc;
            this.rc=rc;
        }
    }
    Node[] st;
    char[] a;
    Node join(Node x,Node y){
        if(x==null) return y;
        if(y==null) return x;
        Node z=new Node(
            x.len+y.len,
            x.pre,
            y.suf,
            Math.max(x.mx,y.mx),
            x.lc,
            y.rc
        );
        if(x.rc==y.lc){
            z.mx=Math.max(z.mx,x.suf+y.pre);
            if(x.pre==x.len)
             z.pre=x.len+y.pre;
            if(y.suf==y.len)
                z.suf=y.len+x.suf;
        }

        return z;
    }
    void build(int p,int l,int r){
        if(l==r){
            st[p]=new Node(1,1,1,1,a[l],a[l]);
            return;
        }
        int m=(l+r)/2;
        build(p*2,l,m);
        build(p*2+1,m+1,r);
        st[p]=join(st[p*2],st[p*2+1]);
    }
    void update(int p,int l,int r,int idx,char c){
        if(l==r){
            a[idx]=c;
            st[p]=new Node(1,1,1,1,c,c);
            return;
        }
        int m=(l+r)/2;
        if(idx<=m)
            update(p*2,l,m,idx,c);
        else
            update(p*2+1,m+1,r,idx,c);
        st[p]=join(st[p*2],st[p*2+1]);
    }
    public int[] longestRepeating(String s,String queryCharacters,int[] queryIndices){
        int n=s.length();
        int k=queryIndices.length;
        a=s.toCharArray();
        st=new Node[4*n];
        build(1,0,n-1);
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            update(
                1,0,n-1,
                queryIndices[i],
                queryCharacters.charAt(i)
            );
            ans[i]=st[1].mx;
        }
        return ans;
    }
}