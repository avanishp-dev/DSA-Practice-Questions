class Solution {
    public int maximumLengthSubstring(String s) {
        int[]count= new int[26];
        int l =0;
        int ans= 0;
        for(int r=0;r<s.length(); r++){
            int x =s.charAt(r)-'a';
            count[x]++;
            while(count[x]>2){
                count[s.charAt(l)-'a']--;
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}
