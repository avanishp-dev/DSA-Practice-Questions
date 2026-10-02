class Solution {
    public String lexiString(String s) {
        int n=s.length();
        String str=s+s;
        int i=0,j=1,k=0;
        while(i<n&&j<n&&k<n){
            char a=str.charAt(i+k);
            char b=str.charAt(j+k);
            if(a==b){
                k++;
            }else if(a>b){
                i=i+k+1;
                if(i<=j)i=j+1;
                k=0;
            }else{
                j=j+k+1;
                if(j<=i)j=i+1;
                k=0;
            }
        }
        int start=Math.min(i,j);
        return str.substring(start,start+n);
    }
}