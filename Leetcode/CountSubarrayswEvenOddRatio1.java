package lcquestions;
public class CountSubarrayswEvenOddRatio1 {
     public int countRatioSubarrays(int[] nums, int a, int b) {
        int n=nums.length;
        int[]prefixev=new int[n+1];
        int[]prefixodd=new int[n+1];
        for(int i=0;i<n;i++){
            prefixev[i+1]= prefixev[i];
            prefixodd[i+1]= prefixodd[i];
            if(nums[i]%2==0)
                prefixev[i+1]++;
            else
                prefixodd[i+1]++;
        }
            int answer=0;
            for(int start=0;start<n;start++){
                for(int end=start;end<n;end++){
                    int even=prefixev[end+1]-prefixev[start];
                    int odd=prefixodd[end+1]-prefixodd[start];
                    if(odd>0 && 1L*b*even<=1L*a*odd){
                        answer++;
                    }
                    
                }
            }
       return answer; 
    }
}