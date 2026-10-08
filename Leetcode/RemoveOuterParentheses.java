class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans=new StringBuilder();
        int start=0,count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') count++;
            else count--;
            if(count==0){
                ans.append(s.substring(start+1,i));
                start=i+1;
            }
        }
        return ans.toString();
    }
}