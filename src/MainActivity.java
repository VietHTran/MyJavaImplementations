import java.*;
import java.util.ArrayList;

import TrieImplementation.*;
public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrieSolution sol= new TrieSolution();
		//Generate test case
		ArrayList<String> words= new ArrayList<String>();
		words.add("harambe");
		words.add("dixout");
		words.add("harmony");
		words.add("dixon");
		words.add("dog");
		words.add("duck");
		words.add("zebra");
		words.add("donkey");
		ArrayList<String> res=sol.shortestUniquePrefix(words);
		for (int i=0;i<res.size();i++) {
			System.out.println(res.get(i));
		}
	}
}
