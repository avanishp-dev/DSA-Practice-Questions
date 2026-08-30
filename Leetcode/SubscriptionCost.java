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
		    int X=sc.nextInt();
		    int Y=sc.nextInt();
		    if(N<=3){
		        System.out.println(N*X);
		    }
		    else{
		        System.out.println(3*X+(N-3)*Y);
		    }
		}
	}
}