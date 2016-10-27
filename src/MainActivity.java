import java.*;
import java.util.*;
import BitManipulation.*;

public class MainActivity {
	public static void main(String[] args) {
		ArrayList<Integer> test= new ArrayList<Integer>();
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(4);
		test.add(3);
		test.add(2);
		test.add(3);
		test.add(1);
		test.add(2);
		test.add(4);
		//{2,3,4,4,3,2,3,1,2,4} expected result=1
		System.out.println(BitManipulation.elementsAppearThrice(test));
	}
}
