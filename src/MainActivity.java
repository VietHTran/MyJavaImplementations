import java.*;
import java.util.*;
import MathTheories.*;

public class MainActivity {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		ModularExponentiation mE= new ModularExponentiation();
		System.out.print("Base: ");
		int a=s.nextInt();
		System.out.print("Power: ");
		int b=s.nextInt();
		System.out.print("Modular: ");
		int m=s.nextInt();
		System.out.print("Result: "+mE.solution(a, b, m));
	}
}
