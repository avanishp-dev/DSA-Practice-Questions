package lcquestions;

public class ThreeSumCloset {
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); 
        int n = nums.length; 
        int min_value = Integer.MAX_VALUE; 
        int result_Sum = 0; 

        for (int i = 0; i <= n - 3; i++) { 
            int left = i + 1; 
            int right = n - 1; 

            while (left < right) { 
                int Sum = nums[i] + nums[left] + nums[right]; 
                int diff = Math.abs(Sum - target); 

                if (diff < min_value) { 
                    min_value = diff; 
                    result_Sum = Sum; 
                } 

                if (Sum == target) { 
                    return Sum; 
                } else if (Sum < target) { 
                    left++; 
                } else { 
                    right--; 
                } 
            } 
        } 
        return result_Sum; 
    } 
}

