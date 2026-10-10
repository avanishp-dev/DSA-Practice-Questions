class Solution {
    public boolean balancePan(int a, int b) {
        while(b>0){
            int rem=b%a;
            if(rem==0||rem==1){
                b/=a;
            }else if(rem==a-1){
                b=b/a+1;
            }else{
                return false;
            }
        }
        return true;
    }
}