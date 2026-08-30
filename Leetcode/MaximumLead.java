import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt();
		int S1=0;
		int S2=0;
		int maxLead=0;
		int winner=0;
		for(int i=0;i<N;i++){
		    int S=sc.nextInt();
		    int T=sc.nextInt();
		    S1=S1+S;
		    S2=S2+T;
		    int lead=0;
		    if(S1>S2){
		        lead=S1-S2;
		        if(lead>maxLead){
		            maxLead=lead;
		            winner=1;
		        }
		    }
		    else{
		        lead= S2-S1;
		    if(lead>maxLead){
		        maxLead=lead;
		        winner=2;
		    }
		  }
		}
		System.out.println(winner+" "+maxLead);
	}
}
