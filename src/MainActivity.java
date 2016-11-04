import java.*;
import java.io.IOException;
import java.util.*;
import DynamicProgramming.*;

public class MainActivity {
	public static void main(String[] args) throws IOException {
		ArrayList<ArrayList<Integer>> test= new ArrayList<ArrayList<Integer>>();
		Scanner s= new Scanner(System.in);
		System.out.println("Number of rows: ");
		int n=s.nextInt();
		System.out.println("Number of columns: ");
		int m=s.nextInt();
		for (int i=0;i<n;i++) {
			ArrayList<Integer> holder= new ArrayList<Integer>();
			for (int k=0;k<m;k++) {
				int u=s.nextInt();
				if (u!=1 && u!=0) {
					throw new IOException("Input can only 1 and 0 only");
				}
				holder.add(u);
			}
			test.add(holder);
		}
		System.out.println("Max Rectangle: "+(new MaxRectInBinaryMatrix()).maximalRectangle(test));
	}
}
