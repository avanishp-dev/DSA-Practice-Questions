import java.util.*;
import java.lang.*;
import java.io.*;

class EqualChocolate{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int A=sc.nextInt();
		int B=sc.nextInt();
		int C=sc.nextInt();
		int D=sc.nextInt();
		System.out.println((A*B)==(C*D)?"Yes":"No");
	}
}
