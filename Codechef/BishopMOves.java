import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		int X1=sc.nextInt();
		int Y1=sc.nextInt();
		int X2=sc.nextInt();
		int Y2=sc.nextInt();
		if(X1+Y1==X2+Y2|| X1-Y1==X2-Y2){
		    System.out.println(1);
		}
		else if((X1+Y1)%2!=(X2+Y2)%2){
		    System.out.println(-1);
		}
		else{
		    System.out.println(2);
		}
	 }
   }
}
