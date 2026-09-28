class Solution {
    public int findMaximumPairs(String s){
            int count=0;
            int i=0;
            while(i<s.length()-1){
                if(s.charAt(i)!=s.charAt(i+1)){
                    count++;
                    i+=2;
                } 
                else{
                    i++;
                }
            }
            return count;
        }
    }