class Solution {
    static String[][] dp = new String[55][35];
    static boolean init = false;
    
    static void build(){
        if(init) return;
        for(int i=0;i<55;i++){
            for(int j=0;j<35;j++) dp[i][j]=null;
        }
        dp[0][0] = "";
        int[] d2 = {1,0,2,1,3,0};
        int[] d3 = {0,1,0,1,0,2};
        char[] dc = {'2','3','4','6','8','9'};
        for(int len=1;len<=85;len++){
            String[][] next = new String[55][35];
            for(int i=0;i<55;i++){
                for(int j=0;j<35;j++){
                    if(dp[i][j]!=null){
                        if(next[i][j]==null||cmp(dp[i][j],next[i][j])<0) next[i][j] = dp[i][j];
                        for(int k=0;k<6;k++){
                            int ni = Math.min(54,i+d2[k]);
                            int nj = Math.min(34,j+d3[k]);
                            String cand = add(dp[i][j],dc[k]);
                            if(next[ni][nj]==null||cmp(cand,next[ni][nj])<0) next[ni][nj] = cand;
                        }
                    }
                }
            }
            dp = next;
        }
        for(int i=53;i>=0;i--){
            for(int j=33;j>=0;j--){
                String best = dp[i][j];
                if(i<53&&dp[i+1][j]!=null){
                    if(best==null||cmp(dp[i+1][j],best)<0) best = dp[i+1][j];
                }
                if(j<33&&dp[i][j+1]!=null){
                    if(best==null||cmp(dp[i][j+1],best)<0) best = dp[i][j+1];
                }
                dp[i][j] = best;
            }
        }
        init = true;
    }
    
    static int cmp(String a,String b){
        if(a.length()!=b.length()) return Integer.compare(a.length(),b.length());
        return a.compareTo(b);
    }
    
    static String add(String s,char c){
        char[] res = new char[s.length()+1];
        int i = 0;
        while(i<s.length()&&s.charAt(i)<c){
            res[i] = s.charAt(i);
            i++;
        }
        res[i] = c;
        while(i<s.length()){
            res[i+1] = s.charAt(i);
            i++;
        }
        return new String(res);
    }
    
    int get(int d,int p){
        if(p==2){
            if(d==8) return 3;
            if(d==4) return 2;
            if(d==2||d==6) return 1;
        }else if(p==3){
            if(d==9) return 2;
            if(d==3||d==6) return 1;
        }else if(p==5){
            if(d==5) return 1;
        }else if(p==7){
            if(d==7) return 1;
        }
        return 0;
    }
    
    public String smallestNumber(String num,long t){
        build();
        long temp = t;
        int req2 = 0,req3 = 0,req5 = 0,req7 = 0;
        while(temp%2==0){req2++;temp/=2;}
        while(temp%3==0){req3++;temp/=3;}
        while(temp%5==0){req5++;temp/=5;}
        while(temp%7==0){req7++;temp/=7;}
        if(temp>1) return "-1";
        
        int n = num.length();
        int fz = num.indexOf('0');
        if(fz==-1) fz = n;
        
        int[] pref2 = new int[n+1];
        int[] pref3 = new int[n+1];
        int[] pref5 = new int[n+1];
        int[] pref7 = new int[n+1];
        for(int i=0;i<n;i++){
            int d = num.charAt(i)-'0';
            pref2[i+1] = pref2[i]+get(d,2);
            pref3[i+1] = pref3[i]+get(d,3);
            pref5[i+1] = pref5[i]+get(d,5);
            pref7[i+1] = pref7[i]+get(d,7);
        }
        
        for(int i=Math.min(n,fz);i>=0;i--){
            int p2 = pref2[i];
            int p3 = pref3[i];
            int p5 = pref5[i];
            int p7 = pref7[i];
            
            int rem2 = Math.max(0,req2-p2);
            int rem3 = Math.max(0,req3-p3);
            int rem5 = Math.max(0,req5-p5);
            int rem7 = Math.max(0,req7-p7);
            
            if(i==n){
                if(rem2==0&&rem3==0&&rem5==0&&rem7==0) return num;
                continue;
            }
            
            int startD = num.charAt(i)-'0'+1;
            for(int d=Math.max(1,startD);d<=9;d++){
                int r2 = Math.max(0,rem2-get(d,2));
                int r3 = Math.max(0,rem3-get(d,3));
                int r5 = Math.max(0,rem5-get(d,5));
                int r7 = Math.max(0,rem7-get(d,7));
                
                int R = n-1-i;
                int R_new = R-r5-r7;
                if(R_new<0) continue;
                
                int l2 = Math.min(54,r2);
                int l3 = Math.min(34,r3);
                String S = dp[l2][l3];
                
                if(S!=null&&S.length()<=R_new){
                    StringBuilder res = new StringBuilder();
                    res.append(num.substring(0,i)).append(d);
                    int ones = R_new-S.length();
                    StringBuilder suf = new StringBuilder();
                    for(int k=0;k<ones;k++) suf.append('1');
                    for(int k=0;k<r5;k++) suf.append('5');
                    for(int k=0;k<r7;k++) suf.append('7');
                    suf.append(S);
                    char[] arr = suf.toString().toCharArray();
                    Arrays.sort(arr);
                    res.append(new String(arr));
                    return res.toString();
                }
            }
        }
        
        int l2 = Math.min(54,req2);
        int l3 = Math.min(34,req3);
        String S = dp[l2][l3];
        int minLen = req5+req7+S.length();
        int L = Math.max(n+1,minLen);
        
        int ones = L-req5-req7-S.length();
        StringBuilder res = new StringBuilder();
        for(int k=0;k<ones;k++) res.append('1');
        for(int k=0;k<req5;k++) res.append('5');
        for(int k=0;k<req7;k++) res.append('7');
        res.append(S);
        
        char[] arr = res.toString().toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}