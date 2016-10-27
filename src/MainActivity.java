import java.*;
import java.util.*;
import SegmentTree.*;

public class MainActivity {
	public static void main(String[] args) {
		Integer[] h={5,3,2,6,1,4};
		Integer[] iF={0,1,2,0,3,2};
		ArrayList<Integer> hL= new ArrayList<Integer> (Arrays.asList(h));
		ArrayList<Integer> iFL= new ArrayList<Integer> (Arrays.asList(iF));
		ArrayList<Integer> res=SegmentTreeSolution.OrderByPeopleHeights(hL,iFL);
		for (int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
		}
	}
}
