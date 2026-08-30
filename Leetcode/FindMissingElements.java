class FindMissingElements {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> l = new ArrayList<>();
        int a=nums[0];
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=a){l.add(a);a++;} 
            a++;

        }
        return l;
    }
}