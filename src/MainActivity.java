import java.*;
import java.io.IOException;
import java.util.*;
import DynamicProgramming.*;

public class MainActivity {
	public static void main(String[] args) throws IOException {
		ArrayList<ArrayList<Integer>> test= new ArrayList<ArrayList<Integer>>();
		Scanner s= new Scanner(System.in);
		System.out.println("Number of nodes:");
		int n=s.nextInt();
		System.out.println((new UniqueBinarySearchTree()).numTrees(n));
	}
}
