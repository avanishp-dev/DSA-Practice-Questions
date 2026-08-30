import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T-->0){
		    int N=sc.nextInt();
		    long[]c=new long[N];
		    for(int i=0;i<N;i++){
		        c[i]=sc.nextLong();
		    }
		    long ans=0;
		    for(int i=0;i<N;i++){
		        ans=Math.max(ans,c[i]);
		        for(int j=i+1;j<N;j++){
		            if(c[i]<=c[j]){
		                ans=Math.max(ans,c[i]+c[j]);
		            }
		        }
		    }
		    System.out.println(ans);
		}
	}
}