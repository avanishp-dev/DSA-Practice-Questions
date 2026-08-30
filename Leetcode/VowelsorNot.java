package gfg;
import java.util.Scanner;
public class VowelsorNot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        ch = Character.toLowerCase(ch);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        sc.close();
	}

}
