import java.util.Arrays;
import java.util.Scanner;

public class ClosestScores {
    public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc= new Scanner(System.in);
	    int n=sc.nextInt();
	    int[]arr= new int[n];
	    for(int i=0;i<n;i++){
	        arr[i]=sc.nextInt();
	    }
	    Arrays.sort(arr);
	    int ans=Integer.MAX_VALUE;
	    for(int i=1;i<n;i++){
	        ans=Math.min(ans,arr[i]-arr[i-1]);
	    }
	    System.out.println(ans);
	}
}