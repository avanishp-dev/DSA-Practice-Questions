class Solution {
    public int minDeletions(int[] arr) {
       ArrayList<Integer>lis =new ArrayList<>();
        for(int num:arr) {
            int idx =Collections.binarySearch(lis,num);

            if(idx<0){
                idx =-(idx + 1);
            }
            if(idx==lis.size()){
                lis.add(num);
            }
            else{
                lis.set(idx,num);
            }
        }
        return arr.length-lis.size();
    }
}