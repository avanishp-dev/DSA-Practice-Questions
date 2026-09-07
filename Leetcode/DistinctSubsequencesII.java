class Solution{
    public int distinctSubseqII(String s){
        long m=1000000007,a=0,d[]=new long[26];
        for(byte c:s.getBytes()){
            long p=d[c-97];
            d[c-97]=(a+1)%m;
            a=(a*2+1-p+m)%m;
        }
        return(int)a;
    }
}