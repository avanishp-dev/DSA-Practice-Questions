import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] a) { 
        List<List<Integer>> result = new ArrayList<>(); 
        int n = a.length; 
        Arrays.sort(a); 
        for (int i = 0; i < n - 2; i++) { 
            if (i > 0 && a[i] == a[i-1]){ 
                continue; 
            } 
            int left = i + 1; 
            int right = n - 1; 
            int Sum = -1 * a[i]; 
            while (left < right) { 
                int s = a[left] + a[right]; 
                if (s == Sum) { 
                    result.add(Arrays.asList(a[i], a[left], a[right])); 
                    left++; 
                    right--; 
                    while (left < right && a[left] == a[left-1]) left++; 
                    while (left < right && a[right] == a[right+1]) right--; 
                } else if (s < Sum) { 
                    left++; 
                } else { 
                    right--; 
                } 
            } 
        } 
        return result; 
    }

    public static void main(String[] args) {
        ThreeSum runner = new ThreeSum();
        int[] testInput = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = runner.threeSum(testInput);
        System.out.println(triplets);
    } 
}
