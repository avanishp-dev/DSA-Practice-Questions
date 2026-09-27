class Solution {
    public int longestPath(String s,int[][] edges) {
        int n=s.length();
        ArrayList<Integer>[] g=new ArrayList[n];
        for(int i=0;i<n;i++) g[i]=new ArrayList<>();
        for(int[] e:edges){
            int u=e[0]-1,v=e[1]-1;
            g[u].add(v);
            g[v].add(u);
        }

        int[] par=new int[n],order=new int[n];
        Arrays.fill(par,-1);
        order[0]=0;
        par[0]=0;
        int size=1;

        for(int i=0;i<size;i++){
            int u=order[i];
            for(int v:g[u]){
                if(par[v]==-1){
                    par[v]=u;
                    order[size++]=v;
                }
            }
        }

        int[] r=new int[n],b=new int[n],start=new int[n],end=new int[n];
        int ans=1;

        for(int k=n-1;k>=0;k--){
            int u=order[k];

            if(s.charAt(u)=='R'){
                int r1=0,r2=0,ri1=-1,ri2=-1;
                int x1=0,x2=0,xi1=-1,xi2=-1;

                for(int v:g[u]){
                    if(par[v]!=u) continue;

                    if(s.charAt(v)=='R'){
                        int x=r[v];
                        if(x>r1){
                            r2=r1;ri2=ri1;
                            r1=x;ri1=v;
                        }else if(x>r2){
                            r2=x;ri2=v;
                        }

                        x=start[v];
                        if(x>x1){
                            x2=x1;xi2=xi1;
                            x1=x;xi1=v;
                        }else if(x>x2){
                            x2=x;xi2=v;
                        }
                    }else{
                        int x=b[v];
                        if(x>x1){
                            x2=x1;xi2=xi1;
                            x1=x;xi1=v;
                        }else if(x>x2){
                            x2=x;xi2=v;
                        }
                    }
                }

                r[u]=r1+1;
                b[u]=0;
                start[u]=x1+1;
                end[u]=r[u];

                int best=1+r1+r2;
                int cross=-1;

                if(ri1!=xi1) cross=Math.max(cross,r1+x1);
                if(ri1!=xi2) cross=Math.max(cross,r1+x2);
                if(ri2!=xi1) cross=Math.max(cross,r2+x1);

                best=Math.max(best,1+cross);
                ans=Math.max(ans,best);
                ans=Math.max(ans,start[u]);
                ans=Math.max(ans,r[u]);
            }else{
                int b1=0,b2=0,bi1=-1,bi2=-1;
                int e1=0,e2=0,ei1=-1,ei2=-1;

                for(int v:g[u]){
                    if(par[v]!=u) continue;

                    int x=b[v];
                    if(x>b1){
                        b2=b1;bi2=bi1;
                        b1=x;bi1=v;
                    }else if(x>b2){
                        b2=x;bi2=v;
                    }

                    x=s.charAt(v)=='B'?end[v]:r[v];

                    if(x>e1){
                        e2=e1;ei2=ei1;
                        e1=x;ei1=v;
                    }else if(x>e2){
                        e2=x;ei2=v;
                    }
                }

                b[u]=b1+1;
                r[u]=0;
                start[u]=b[u];
                end[u]=e1+1;

                int best=1+b1+b2;
                int cross=-1;

                if(bi1!=ei1) cross=Math.max(cross,b1+e1);
                if(bi1!=ei2) cross=Math.max(cross,b1+e2);
                if(bi2!=ei1) cross=Math.max(cross,b2+e1);

                best=Math.max(best,1+cross);
                ans=Math.max(ans,best);
                ans=Math.max(ans,end[u]);
                ans=Math.max(ans,b[u]);
            }
        }

        return ans;
    }
}