import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		String s=sc.next();
		int count=0;
		for(int i=0;i<b;i++){
		    if(s.charAt(i)=='W'){
		        count++;
		    }
		}
		int minimum=count;
		for(int i=b;i<a;i++){
		    if(s.charAt(i-b)=='W'){
		        count--;
		    }
		    if(s.charAt(i)=='W'){
		        count++;
		    }
		    minimum=Math.min(minimum,count);
		}
		System.out.println(minimum);
	}
}
