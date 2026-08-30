class Solution {
    public boolean stoneGameIX(int[] stones) {
        int a=0,b=0,c=0;
        for(int x:stones){
            x=x%3;
            if(x==0)
               a++;
            else if(x==1)
                b++;
            else
                c++;
        }
        if(a%2==0){
            if(b>0 && c>0)
                return true;

            return false;
        }
        if(Math.abs(b-c)>2)
            return true;
        return false;
    }
}