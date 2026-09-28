import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
	    String s=sc.next();
	    int k=sc.nextInt();
	    int n=s.length();
	    int ans=0;
	    for(int i=0;i<n;i++){
	        int ones=0;
	        int zeros=0;
	        for(int j=i;j<n;j++){
	            if(s.charAt(j)=='1')
	            ones++;
	            else
	            zeros++;
	            int difference=Math.abs(ones-zeros);
	            if(difference%2==0 && difference/2<=k){
	                ans=Math.max(ans,j-i+1);
	            }
	        }
	    }
	    System.out.println(ans);
	}
}
