package Codechef;
import java.util.Scanner;
public class BalancedIngredients {
    	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int d=sc.nextInt();
		if(a==0|| b==0||c==0||d==0||a+b==0||a+c==0||a+d==0||b+c==0||b+d==0||c+d==0|a+b+c==0||a+b+d==0||a+c+d==0||b+c+d==0||a+b+c+d==0){
		    System.out.println("Yes");
		}
		else{
		    System.out.println("No");
		}
	}
}
