class Solution {
    public int largestInteger(int[] nums, int k){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        for(int i=0;i+k<=n;i++){
            HashSet<Integer> s = new HashSet<>();

            for(int j=i;j<i+k;j++){
                s.add(nums[j]);
            }
            for(int x:s){
                mp.put(x,mp.getOrDefault(x,0)+1);
            }
        }
        int ans = -1;
        for(int x:mp.keySet()){
            if(mp.get(x)==1){
                if(x>ans) ans=x;
            }
        }
        return ans;
    }
}