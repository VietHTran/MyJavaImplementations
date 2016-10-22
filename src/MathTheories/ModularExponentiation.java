package MathTheories;

//Problems: Given a,b,m --> Solve for (a^b)%m
public class ModularExponentiation {
	//Solution is based on formulas:
	//1. ((a mod m)*(b mod m)) mod m == (a*b) mod m
	//2. a^b==(a*a)^(b/2)
	public int solution(int a, int b, int m) {
		long result=1;
		//a^0==1
		if (b==0) {
			return 1%m;
		}
		//Examples: 4%2==0 ==> (4^x)%2==0
		if (a%m==0) {
			return 0;
		}
		//Prevent overflowing still guarantee correct result as ((a mod m)^2) mod m == (a^2) mod m; 
		a%=m;
		while (b>0) {
			// Since a^b==(a*a)^(b/2) only works for even number 
			//--> reduce 1 power by multiply result with a
			if (b%2==1) {
				//((result mod m)*(a mod m)==(a*result) mod m
				result=(result*a)%m;
			}
			//((a mod m)^b) mod m == ((a mod m)^2)^(b/2) mod m
			a=(a*a)%m;
			//x/(2^i)==x>>i --> b/2==b>>1
			//The only way to get b==0 (end loop) when divide b for 2 is when b==1
			//--> The result variable always get updated with a in the last loop (b==1)
			//--> When (b==0) --> We don't need to update the new a value for the result
			b=b>>1;
		}
		return (int)result;
	}
}
