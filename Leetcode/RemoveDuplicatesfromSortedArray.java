package lcquestions;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
        int officer=0;
        int res=1;
        int cm=1;
        while(cm<nums.length){
            if(nums[cm]==nums[cm-1]){
                cm++;
                continue;
            }
            nums[officer+1]=nums[cm];
            officer++;
            res++;
            cm++;
        }
        return res;
    }
}
