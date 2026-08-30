import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int[]height= new int[n];
		for(int i=0;i<n;i++){
		    height[i]=sc.nextInt();
		}
		int left=0;
		int right=n-1;
		int maximum=0;
		while(left<right){
		    int wid=right-left;
		    int H= Math.min(height[left],height[right]);
		    int wtr= wid*H;
		    maximum=Math.max(maximum,wtr);
		    if(height[left]<height[right]){
		        left++;
		    }
		    else{
		        right--;
		    }
		}
		System.out.println(maximum);
	}
}
