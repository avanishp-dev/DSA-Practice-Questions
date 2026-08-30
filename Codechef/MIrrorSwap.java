import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc= new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0){
	        int n=sc.nextInt();
	        int[]a=new int[2*n];
	        for(int i=0;i<2*n;i++){
	            a[i]=sc.nextInt();
	        }
	        long sum=0;
	        for(int i=0;i<n;i++){
	            sum+=Math.max(a[i],a[2*n-1-i]);
	        }
	        System.out.println(sum);
	    }
	    sc.close();
	}
}