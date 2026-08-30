package lcquestions;
public class MaximizePairStrengthGCD {
    public long maxPairStrength(int[] nums) {
        long answer=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                long g=gcd(nums[i],nums[j]);
                long strength=(1L*nums[i]*nums[j])/(g*g);
                answer=Math.max(answer,strength);
            }
        }
        return answer;
    }
    private long gcd(long a, long b){
        while(b!=0){
            long temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}